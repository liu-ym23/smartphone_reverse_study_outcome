package com.bytedance.geckox;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Deprecated
public class OptionCheckUpdateParams {
    private Map<String, Map<String, Object>> customParam;
    private boolean enableDownloadAutoRetry;
    private boolean enableRetry;
    private boolean enableThrottle;
    private boolean lazyUpdate;
    private pa.a listener;
    private boolean requestWhenHasLocalVersion;
    private String tag;
    private int updatePriority;

    @Keep
    public interface ChannelUpdatePriority {
        public static final int HIGH = 2;
        public static final int LOW = 0;
        public static final int MIDDLE = 1;
        public static final int USE_INTERACTION = 3;
    }

    @Keep
    public interface CustomValue {
        Object getValue();
    }

    public OptionCheckUpdateParams() {
        this.enableThrottle = true;
        this.customParam = new HashMap();
        this.enableRetry = true;
        this.enableDownloadAutoRetry = true;
        this.updatePriority = 1;
        this.requestWhenHasLocalVersion = true;
        this.tag = null;
    }

    public int getChannelUpdatePriority() {
        return this.updatePriority;
    }

    public Map<String, Map<String, Object>> getCustomParam() {
        return this.customParam;
    }

    public pa.a getListener() {
        return this.listener;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isEnableDownloadAutoRetry() {
        return this.enableDownloadAutoRetry;
    }

    public boolean isEnableRetry() {
        return this.enableRetry;
    }

    public boolean isEnableThrottle() {
        return this.enableThrottle;
    }

    public boolean isLazyUpdate() {
        return this.lazyUpdate;
    }

    public boolean isRequestWhenHasLocalVersion() {
        return this.requestWhenHasLocalVersion;
    }

    public OptionCheckUpdateParams setChannelUpdatePriority(int r5) {
        this.updatePriority = r5;
        return this;
    }

    public OptionCheckUpdateParams setCustomParam(Map<String, Map<String, Object>> r5) {
        this.customParam = r5;
        return this;
    }

    public OptionCheckUpdateParams setEnableDownloadAutoRetry(boolean r5) {
        this.enableDownloadAutoRetry = r5;
        return this;
    }

    public OptionCheckUpdateParams setEnableRetry(boolean r5) {
        this.enableRetry = r5;
        return this;
    }

    public OptionCheckUpdateParams setEnableThrottle(boolean r5) {
        this.enableThrottle = r5;
        return this;
    }

    public OptionCheckUpdateParams setLazyUpdate(boolean r5) {
        this.lazyUpdate = r5;
        return this;
    }

    public OptionCheckUpdateParams setListener(pa.a r5) {
        this.listener = r5;
        return this;
    }

    public OptionCheckUpdateParams setRequestWhenHasLocalVersion(boolean r5) {
        this.requestWhenHasLocalVersion = r5;
        return this;
    }

    public void setTag(String r5) {
        this.tag = r5;
    }
}
