package com.obric.cae.userAware;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class SceneCollectionSessionContext {
    private static final SceneCollectionSessionContext INSTANCE = null;
    private volatile String mCategory;
    private volatile String mLastDescriptionFileStem;
    private volatile String mLocation;
    private volatile String mSceneName;

    public static final class Snapshot {
        private final String mCategory;
        private final String mLastDescriptionFileStem;
        private final String mLocation;
        private final String mSceneName;

        public Snapshot(String r1, String r2, String r3, String r4) {
            this.mSceneName = r1;
            this.mCategory = r2;
            this.mLocation = r3;
            this.mLastDescriptionFileStem = r4;
        }

        public SceneCollectionPathBuilder.PathLayout buildLayout(File r7, long r8) {
            return SceneCollectionPathBuilder.buildLayout(r7, this.mSceneName, this.mCategory, this.mLocation, r8);
        }

        public String getDescriptionFileStem() {
            if (this.mLastDescriptionFileStem.isEmpty() == true) goto L7;
            return this.mLastDescriptionFileStem;
        L7:
            return SceneCollectionPathBuilder.buildDescriptionFileStem(this.mSceneName, this.mCategory, this.mLocation);
        }

        public boolean hasPathInfo() {
            if (this.mSceneName.isEmpty() == false) goto L5;
        L9:
            return false;
        L5:
            if (this.mCategory.isEmpty() == true) goto L9;
            if (this.mLocation.isEmpty() == true) goto L9;
            return true;
        }
    }

    static {
        INSTANCE = new SceneCollectionSessionContext();
    }

    private SceneCollectionSessionContext() {
        this.mSceneName = "";
        this.mCategory = "";
        this.mLocation = "";
        this.mLastDescriptionFileStem = "";
    }

    public static SceneCollectionSessionContext getInstance() {
        return INSTANCE;
    }

    public static String sanitizeCollectionDesc(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return r4;
    L5:
        if (r4.isEmpty() == true) goto L16;
        if (r5 == null) goto L18;
        String r6 = UserAwareUtil.getStringValueFromXML(r5, ZeusTransformUtils.mapRes(R.string.user_aware_user_select_scene, TypedValues.Custom.S_STRING, "user_aware_user_select_scene"));
        if (r4.startsWith(r6) == false) goto L12;
        r4 = r4.substring(r6.length());
    L12:
        if (r4.contains("/") == true) goto L14;
        return r4;
    L14:
        return r4.replace("/", "_");
    L18:
        return r4;
    L16:
        return r4;
    }

    public void clear() {
        this.mSceneName = "";
        this.mCategory = "";
        this.mLocation = "";
        this.mLastDescriptionFileStem = "";
    }

    public String getDescriptionFileStem(String r4) {
        String r0 = SceneCollectionPathBuilder.buildDescriptionFileStem(this.mSceneName, this.mCategory, this.mLocation);
        if (r0.isEmpty() == false) goto L6;
        r0 = SceneCollectionPathBuilder.sanitizeSegment(r4);
    L6:
        if (r0.isEmpty() == true) goto L8;
        this.mLastDescriptionFileStem = r0;
    L8:
        return r0;
    }

    public void setPathInfo(String r1, String r2, String r3) {
        this.mSceneName = SceneCollectionPathBuilder.sanitizeSegment(r1);
        this.mCategory = SceneCollectionPathBuilder.sanitizeSegment(r2);
        this.mLocation = SceneCollectionPathBuilder.sanitizeSegment(r3);
    }

    public boolean shouldUseRawOutput() {
        if (this.mSceneName.isEmpty() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mCategory.isEmpty() == true) goto L9;
        if (this.mLocation.isEmpty() == true) goto L9;
        return true;
    }

    public Snapshot snapshot() {
        return new Snapshot(this.mSceneName, this.mCategory, this.mLocation, this.mLastDescriptionFileStem);
    }

    public void updateLastDescriptionFileStem(String r1) {
        this.mLastDescriptionFileStem = r1;
    }
}
