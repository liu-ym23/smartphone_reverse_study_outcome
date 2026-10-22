package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006("}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/DataSource;", "", "()V", "baseDir", "", "getBaseDir", "()Ljava/lang/String;", "setBaseDir", "(Ljava/lang/String;)V", "isLooping", "", "()Z", "setLooping", "(Z)V", "landPath", "getLandPath", "setLandPath", "landScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getLandScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setLandScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "portPath", "getPortPath", "setPortPath", "portScaleType", "getPortScaleType", "setPortScaleType", "getPath", "orientation", "", "getScaleType", "isValid", "setLandscapePath", "landscapePath", "landscapeScaleType", "setPortraitPath", "portraitPath", "portraitScaleType", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7790b;
    public String c;
    private ScaleType d;
    private ScaleType e;
    private boolean f;

    public b() {
    }

    public final String a(int r4) {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.f7789a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseDir");
    L5:
        StringBuilder r2 = r0.append(r1);
        if (1 != r4) goto L11;
        String r3 = this.f7790b;
        if (r3 != null) goto L15;
        String r5 = "portPath";
    L10:
        Intrinsics.throwUninitializedPropertyAccessException(r5);
    L15:
        return r2.append(r3).toString();
    L11:
        r3 = this.c;
        if (r3 != null) goto L15;
        r5 = "landPath";
        goto L10
    }

    public final boolean a() {
        return this.f;
    }

    public final ScaleType b(int r2) {
        if (1 != r2) goto L6;
        return this.d;
    L6:
        return this.e;
    }

    public final boolean b() {
        String r0 = this.f7790b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("portPath");
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        String r1 = this.c;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("landPath");
    L11:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        if (this.d == null) goto L17;
        if (this.e == null) goto L17;
        return true;
    L17:
        return false;
    }
}
