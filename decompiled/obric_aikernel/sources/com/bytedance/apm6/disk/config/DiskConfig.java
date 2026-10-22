package com.bytedance.apm6.disk.config;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiskConfig {
    private List<String> complianceRelativePaths;
    private List<String> customRelativePaths;
    private long diskThresholdBytes;
    private long fileThresholdBytes;
    private long folderThresholdBytes;
    private List<String> ignoredRelativePaths;
    private boolean isSample;
    private long outdatedIntervalMs;
    private int reportExceptionDirMaxCount;
    private int reportMaxCount;
    private int reportMaxOutdatedCount;
    private int reportMaxTopCount;

    public DiskConfig() {
    }

    public List<String> getComplianceRelativePaths() {
        return this.complianceRelativePaths;
    }

    public List<String> getCustomRelativePaths() {
        return this.customRelativePaths;
    }

    public long getDiskThresholdBytes() {
        return this.diskThresholdBytes;
    }

    public long getFileThresholdBytes() {
        return this.fileThresholdBytes;
    }

    public long getFolderThresholdBytes() {
        return this.folderThresholdBytes;
    }

    public List<String> getIgnoredRelativePaths() {
        return this.ignoredRelativePaths;
    }

    public long getOutdatedIntervalMs() {
        return this.outdatedIntervalMs;
    }

    public int getReportExceptionDirMaxCount() {
        return this.reportExceptionDirMaxCount;
    }

    public int getReportMaxCount() {
        return this.reportMaxCount;
    }

    public int getReportMaxOutdatedCount() {
        return this.reportMaxOutdatedCount;
    }

    public int getReportMaxTopCount() {
        return this.reportMaxTopCount;
    }

    public boolean isSample() {
        return this.isSample;
    }

    public void setComplianceRelativePaths(List<String> r10) {
        this.complianceRelativePaths = r10;
    }

    public void setCustomRelativePaths(List<String> r10) {
        this.customRelativePaths = r10;
    }

    public void setDiskThresholdBytes(long r10) {
        this.diskThresholdBytes = r10;
    }

    public void setFileThresholdBytes(long r10) {
        this.fileThresholdBytes = r10;
    }

    public void setFolderThresholdBytes(long r10) {
        this.folderThresholdBytes = r10;
    }

    public void setIgnoredRelativePaths(List<String> r10) {
        this.ignoredRelativePaths = r10;
    }

    public void setOutdatedIntervalMs(long r10) {
        this.outdatedIntervalMs = r10;
    }

    public void setReportExceptionDirMaxCount(int r10) {
        this.reportExceptionDirMaxCount = r10;
    }

    public void setReportMaxCount(int r10) {
        this.reportMaxCount = r10;
    }

    public void setReportMaxOutdatedCount(int r10) {
        this.reportMaxOutdatedCount = r10;
    }

    public void setReportMaxTopCount(int r10) {
        this.reportMaxTopCount = r10;
    }

    public void setSample(boolean r10) {
        this.isSample = r10;
    }

    public String toString() {
        return "DiskConfig{diskThresholdBytes=" + this.diskThresholdBytes + ", folderThresholdBytes=" + this.folderThresholdBytes + ", fileThresholdBytes=" + this.fileThresholdBytes + ", reportMaxCount=" + this.reportMaxCount + ", reportMaxOutdatedCount=" + this.reportMaxOutdatedCount + ", reportMaxTopCount=" + this.reportMaxTopCount + ", reportExceptionDirMaxCount=" + this.reportExceptionDirMaxCount + ", outdatedIntervalMs=" + this.outdatedIntervalMs + ", customRelativePaths=" + this.customRelativePaths + ", ignoredRelativePaths=" + this.ignoredRelativePaths + ", complianceRelativePaths=" + this.complianceRelativePaths + ", isSample=" + this.isSample + '}';
    }
}
