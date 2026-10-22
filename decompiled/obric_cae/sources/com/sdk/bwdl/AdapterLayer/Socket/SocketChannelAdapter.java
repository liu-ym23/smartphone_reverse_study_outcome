package com.sdk.bwdl.AdapterLayer.Socket;

import com.google.protobuf.DescriptorProtos;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SocketChannelAdapter implements IBWDLAdapter {
    private static final String TAG = "SocketChannelAdapter";
    private ArrayList<IBWDLAdapterEventListener> mAdapterEventListenerList;
    private BWDLDevice m_PeerDevice;
    private int m_local_port;
    private ServerSocketChannel m_serverSocketChannel;
    private SocketChannel m_socketChannel;
    private int m_socket_timeout;

    public SocketChannelAdapter() {
        this.mAdapterEventListenerList = new ArrayList();
    }

    private synchronized void notifyConnected() {
        monitor-enter(this);
        ArrayList<IBWDLAdapterEventListener> r8 = this.mAdapterEventListenerList;     // Catch: Throwable -> L15
        monitor-enter(r8);     // Catch: Throwable -> L15
        Iterator<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L12
    L7:
        if (r10.hasNext() == false) goto L9;
        IBWDLAdapterEventListener r11 = r10.next();     // Catch: Throwable -> L12
        BWDLLog.d(TAG, "notifyConnected");     // Catch: Throwable -> L12
        r11.onConnected(this);     // Catch: Throwable -> L12
        goto L7
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized void notifyDisconnected() {
        monitor-enter(this);
        ArrayList<IBWDLAdapterEventListener> r8 = this.mAdapterEventListenerList;     // Catch: Throwable -> L15
        monitor-enter(r8);     // Catch: Throwable -> L15
        Iterator<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L12
    L7:
        if (r10.hasNext() == false) goto L9;
        IBWDLAdapterEventListener r11 = r10.next();     // Catch: Throwable -> L12
        BWDLLog.d(TAG, "notifyConnected");     // Catch: Throwable -> L12
        r11.onDisconnected(this);     // Catch: Throwable -> L12
        goto L7
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void accept() {
        SocketChannel r8 = this.m_serverSocketChannel.accept();     // Catch: IOException -> L6
        this.m_socketChannel = r8;     // Catch: IOException -> L6
        if (r8 == null) goto L11;
        notifyConnected();     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void close() {
        this.m_socketChannel.close();     // Catch: IOException -> L4
        notifyDisconnected();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean connect(BWDLDevice r8) {
        InetSocketAddress r10 = (InetSocketAddress) r8.getDeviceInfo();
        this.m_PeerDevice = r8;
        SocketChannel r11 = SocketChannel.open();     // Catch: IOException -> L5
        this.m_socketChannel = r11;     // Catch: IOException -> L5
        r11.configureBlocking(true);     // Catch: IOException -> L5
        this.m_socketChannel.connect(r10);     // Catch: IOException -> L5
    L8:
        if (this.m_socketChannel.isConnected() == false) goto L11;
        notifyConnected();
        return true;
    L11:
        return false;
    L5:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
        goto L8
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean disconnect(BWDLDevice r8) {
        return false;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void encrypt(BWDLDevice r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public Object getCapabilities() {
        return null;
    }

    public SocketChannel get_socketChannel() {
        return this.m_socketChannel;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean init() {
        this.m_local_port = 0;
        this.m_socket_timeout = BWDLInnerConstant.EVENT_TIME_TOUT;
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int isAdapterReady() {
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void listen() {
        this.m_serverSocketChannel.bind(new InetSocketAddress(DescriptorProtos.Edition.EDITION_UNSTABLE_VALUE));     // Catch: IOException -> L4
        this.m_serverSocketChannel = ServerSocketChannel.open();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int recv(byte[] r8) {
        ByteBuffer r10 = ByteBuffer.wrap(r8);
        return this.m_socketChannel.read(r10);
    L5:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public synchronized void removeBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        monitor-enter(this);
        ArrayList<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;     // Catch: Throwable -> L13
        monitor-enter(r10);     // Catch: Throwable -> L13
        BWDLLog.d(TAG, "removeBWDLAdapterEventListener:" + r8);     // Catch: Throwable -> L10
        this.mAdapterEventListenerList.remove(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void send(BWDLDevice r8, byte[] r10) {
        ByteBuffer r11 = ByteBuffer.wrap(r10);
        this.m_socketChannel.write(r11);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        BWDLLog.d(TAG, e.getMessage());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public synchronized void setBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        monitor-enter(this);
        ArrayList<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;     // Catch: Throwable -> L14
        monitor-enter(r10);     // Catch: Throwable -> L14
        if (r8 != null) goto L17;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L17:
        BWDLLog.d(TAG, "setBWDLAdapterEventListener:" + r8);     // Catch: Throwable -> L11
        this.mAdapterEventListenerList.add(r8);     // Catch: Throwable -> L11
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public synchronized void setBWDLAdapterEventListener(BWDLDevice r8, IBWDLAdapterEventListener r10) {
        monitor-enter(this);
        monitor-exit(this);
    }
}
