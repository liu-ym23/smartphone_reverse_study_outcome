package com.bytedance.apm6.consumer.slardar.config;

import android.text.TextUtils;
import com.bytedance.apm6.util.ListUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandlerConfig {
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private int compressType;
    private List<String> exceptionUrl;
    private boolean isEncrypt;
    private boolean isUploadInternalExcetpion;
    private int keepDays;
    private int maxSizeMB;
    private int maxSizeMBToday;
    private long onceReportMaxSizeBytes;
    private long reportInterval;
    private List<String> reportUrlList;
    private List<String> traceReportUrl;

    public SlardarHandlerConfig() {
        this.isEncrypt = true;
        this.isUploadInternalExcetpion = true;
    }

    public int getCompressType() {
        return this.compressType;
    }

    public List<String> getExceptionUrl() {
        return this.exceptionUrl;
    }

    public int getKeepDays() {
        return this.keepDays;
    }

    public int getMaxSizeMB() {
        return this.maxSizeMB;
    }

    public int getMaxSizeMBToday() {
        return this.maxSizeMBToday;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    public long getReportInterval() {
        return this.reportInterval;
    }

    public List<String> getReportUrlList() {
        return this.reportUrlList;
    }

    public List<String> getTraceReportUrl() {
        return this.traceReportUrl;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public boolean isUploadInternalException() {
        return this.isUploadInternalExcetpion;
    }

    public void setCompressType(int r10) {
        this.compressType = r10;
    }

    public void setEncrypt(boolean r10) {
        this.isEncrypt = r10;
    }

    public void setExceptionUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        this.exceptionUrl = r11;
        r11.add(r10);
    }

    public void setKeepDays(int r10) {
        this.keepDays = r10;
    }

    public void setMaxSizeMB(int r10) {
        this.maxSizeMB = r10;
    }

    public void setMaxSizeMBToday(int r10) {
        this.maxSizeMBToday = r10;
    }

    public void setOnceReportMaxSizeBytes(long r10) {
        this.onceReportMaxSizeBytes = r10;
    }

    public void setReportInterval(long r10) {
        this.reportInterval = r10;
    }

    public void setReportUrlList(List<String> r10) {
        if (ListUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.reportUrlList = r10;
    }

    public void setTraceReportUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        this.traceReportUrl = r11;
        r11.add(r10);
    }

    public void setUploadInternalException(boolean r10) {
        this.isUploadInternalExcetpion = r10;
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.onceReportMaxSizeBytes + ", reportUrlList=" + this.reportUrlList + ", exceptionUrl=" + this.exceptionUrl + ", traceReportUrl=" + this.traceReportUrl + ", isEncrypt=" + this.isEncrypt + ", isUploadInternalExcetpion=" + this.isUploadInternalExcetpion + ", reportInterval=" + this.reportInterval + ", maxSizeMB=" + this.maxSizeMB + ", keepDays=" + this.keepDays + ", maxSizeMBToday=" + this.maxSizeMBToday + '}';
    }
}
