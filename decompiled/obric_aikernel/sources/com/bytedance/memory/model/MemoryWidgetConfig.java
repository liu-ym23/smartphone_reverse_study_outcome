package com.bytedance.memory.model;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MemoryWidgetConfig implements Serializable {
    private static final long serialVersionUID = 2435829043493095963L;
    private boolean mClientAnalyse;
    private boolean mCombineDumpAndUpload;
    private boolean mDeepShrink;
    private a mDumpShrinkConfig;
    private String mFilePath;
    private boolean mIsDebug;
    private int mMemoryRate;
    private int mNumAnalyse;
    private int mRunStrategy;
    private b mShrinkConfig;
    private com.bytedance.memory.model.a mTeaReport;

    public static class Builder implements Serializable {
        private static final long serialVersionUID = 2629625684428405094L;
        private boolean mClientAnalyse;
        private boolean mDeepShrink;
        private a mDumpShrinkConfig;
        private String mFilePath;
        private boolean mIsDebug;
        private int mMemoryRate;
        private int mNumAnalyse;
        private int mRunStrategy;
        private b mShrinkConfig;
        private com.bytedance.memory.model.a mTeaReport;

        public Builder() {
            this.mClientAnalyse = false;
            this.mTeaReport = null;
            this.mNumAnalyse = 200;
            this.mMemoryRate = 90;
            this.mRunStrategy = 1;
            this.mDeepShrink = false;
        }

        public MemoryWidgetConfig build() {
            MemoryWidgetConfig r10 = new MemoryWidgetConfig();
            MemoryWidgetConfig.access$002(r10, this.mIsDebug);
            MemoryWidgetConfig.access$102(r10, this.mClientAnalyse);
            MemoryWidgetConfig.access$202(r10, this.mTeaReport);
            MemoryWidgetConfig.access$302(r10, this.mNumAnalyse);
            MemoryWidgetConfig.access$402(r10, this.mMemoryRate);
            MemoryWidgetConfig.access$502(r10, this.mRunStrategy);
            MemoryWidgetConfig.access$602(r10, this.mShrinkConfig);
            MemoryWidgetConfig.access$702(r10, this.mDumpShrinkConfig);
            MemoryWidgetConfig.access$802(r10, this.mFilePath);
            MemoryWidgetConfig.access$902(r10, this.mDeepShrink);
            return r10;
        }

        public Builder buildClientAnalyse(boolean r10) {
            this.mClientAnalyse = r10;
            return this;
        }

        public Builder buildDebug(boolean r10) {
            this.mIsDebug = r10;
            return this;
        }

        public Builder buildFilePath(String r10) {
            this.mFilePath = r10;
            return this;
        }

        public Builder buildMemoryRate(int r10) {
            this.mMemoryRate = r10;
            return this;
        }

        public Builder buildNumAnalyse(int r10) {
            this.mNumAnalyse = r10;
            return this;
        }

        public Builder buildRunStrategy(int r10) {
            this.mRunStrategy = r10;
            return this;
        }

        public Builder buildTeaReport(com.bytedance.memory.model.a r10) {
            this.mTeaReport = r10;
            return this;
        }

        public Builder deepShrink(boolean r10) {
            this.mDeepShrink = r10;
            return this;
        }

        public Builder dumpAndShrinkConfig(a r10) {
            this.mDumpShrinkConfig = r10;
            return this;
        }

        public Builder shrinkConfig(b r10) {
            this.mShrinkConfig = r10;
            return this;
        }
    }

    public interface a {
        boolean a(File r10);
    }

    public interface b {
        boolean a(File r10, File r11);
    }

    public MemoryWidgetConfig() {
        this.mClientAnalyse = false;
        this.mCombineDumpAndUpload = false;
        this.mTeaReport = null;
        this.mNumAnalyse = 200;
        this.mMemoryRate = 90;
        this.mRunStrategy = 1;
        this.mDeepShrink = false;
    }

    static /* synthetic */ boolean access$002(MemoryWidgetConfig r10, boolean r11) {
        r10.mIsDebug = r11;
        return r11;
    }

    static /* synthetic */ boolean access$102(MemoryWidgetConfig r10, boolean r11) {
        r10.mClientAnalyse = r11;
        return r11;
    }

    static /* synthetic */ com.bytedance.memory.model.a access$202(MemoryWidgetConfig r10, com.bytedance.memory.model.a r11) {
        r10.mTeaReport = r11;
        return r11;
    }

    static /* synthetic */ int access$302(MemoryWidgetConfig r10, int r11) {
        r10.mNumAnalyse = r11;
        return r11;
    }

    static /* synthetic */ int access$402(MemoryWidgetConfig r10, int r11) {
        r10.mMemoryRate = r11;
        return r11;
    }

    static /* synthetic */ int access$502(MemoryWidgetConfig r10, int r11) {
        r10.mRunStrategy = r11;
        return r11;
    }

    static /* synthetic */ b access$602(MemoryWidgetConfig r10, b r11) {
        r10.mShrinkConfig = r11;
        return r11;
    }

    static /* synthetic */ a access$702(MemoryWidgetConfig r10, a r11) {
        r10.mDumpShrinkConfig = r11;
        return r11;
    }

    static /* synthetic */ String access$802(MemoryWidgetConfig r10, String r11) {
        r10.mFilePath = r11;
        return r11;
    }

    static /* synthetic */ boolean access$902(MemoryWidgetConfig r10, boolean r11) {
        r10.mDeepShrink = r11;
        return r11;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean clientAnalyse() {
        return this.mClientAnalyse;
    }

    public a getDumpAndShrinkConfig() {
        return this.mDumpShrinkConfig;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getMemoryRate() {
        return this.mMemoryRate;
    }

    public int getNumAnalyse() {
        return this.mNumAnalyse;
    }

    public int getRunStrategy() {
        return this.mRunStrategy;
    }

    public b getShrinkConfig() {
        return this.mShrinkConfig;
    }

    public com.bytedance.memory.model.a getTeaReport() {
        return this.mTeaReport;
    }

    public boolean isCombineDumpAndUpload() {
        return this.mCombineDumpAndUpload;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public boolean isDeepShrink() {
        return this.mDeepShrink;
    }

    public void setClientAnalyse(boolean r10) {
        this.mClientAnalyse = r10;
    }

    public void setCombineDumpAndUpload(boolean r10) {
        this.mCombineDumpAndUpload = r10;
    }

    public void setMemoryRate(int r10) {
        this.mMemoryRate = r10;
    }

    public void setNumAnalyse(int r10) {
        this.mNumAnalyse = r10;
    }

    public void setRunStrategy(int r10) {
        this.mRunStrategy = r10;
    }

    @NonNull
    public String toString() {
        return "MemoryWidgetConfig{ mIsDebug:" + this.mIsDebug + ", mClientAnalyse:" + this.mClientAnalyse + ", mMemoryRate:" + this.mMemoryRate + ", mRunStrategy:" + this.mRunStrategy + ", mFilePath:" + this.mFilePath + ", mShrinkConfig:" + this.mShrinkConfig + ", mDumpShrinkConfig:" + this.mDumpShrinkConfig + ", mDeepShrink:" + this.mDeepShrink + " }";
    }
}
