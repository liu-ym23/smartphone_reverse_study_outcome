package com.ttnet.org.chromium.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AndroidNetworkLibrary$SocketFd extends Socket {
    public AndroidNetworkLibrary$SocketFd(FileDescriptor r2) throws IOException {
        super(new SocketImplFd(r2));
    }
}
