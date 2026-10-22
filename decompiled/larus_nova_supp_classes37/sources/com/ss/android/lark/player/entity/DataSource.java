package com.ss.android.lark.player.entity;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import java.io.FileDescriptor;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DataSource implements Serializable {
    private AssetFileDescriptor assetFileDescriptor;
    private String cacheKeyPrefix;
    private String data;
    private HashMap<String, String> extra;
    private FileDescriptor fileDescriptor;
    private long id;
    private boolean isLocal;
    private final MutableLiveData<Boolean> showPreloading;
    private String sid;
    private long size;
    private int startPos;
    private String tag;
    private String title;
    private Uri uri;

    public String toString() {
        return "data: " + this.data + ", size: " + this.size + ", uri: " + this.uri + ", fileDescriptor: " + this.fileDescriptor;
    }

    public DataSource() {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
    }

    public AssetFileDescriptor getAssetFileDescriptor() {
        return this.assetFileDescriptor;
    }

    public String getCacheKeyPrefix() {
        return this.cacheKeyPrefix;
    }

    public String getData() {
        return this.data;
    }

    public HashMap<String, String> getExtra() {
        return this.extra;
    }

    public FileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public long getId() {
        return this.id;
    }

    public MutableLiveData<Boolean> getShowPreloading() {
        return this.showPreloading;
    }

    public String getSid() {
        return this.sid;
    }

    public long getSize() {
        return this.size;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public DataSource(String r3) {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
        this.data = r3;
    }

    public void setAssetFileDescriptor(AssetFileDescriptor r1) {
        this.assetFileDescriptor = r1;
    }

    public void setCacheKeyPrefix(String r1) {
        this.cacheKeyPrefix = r1;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setExtra(HashMap<String, String> r1) {
        this.extra = r1;
    }

    public void setFileDescriptor(FileDescriptor r1) {
        this.fileDescriptor = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setIsLocal(boolean r1) {
        this.isLocal = r1;
    }

    public void setSid(String r1) {
        this.sid = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }

    public void setStartPos(int r1) {
        this.startPos = r1;
    }

    public void setTag(String r1) {
        this.tag = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setUri(Uri r1) {
        this.uri = r1;
    }

    public DataSource(String r3, String r4) {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
        this.tag = r3;
        this.data = r4;
    }
}
