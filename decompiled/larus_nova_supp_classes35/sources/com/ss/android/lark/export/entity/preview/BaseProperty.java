package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.tangram.base.props.Props;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "Lcom/ss/android/lark/tangram/base/props/Props;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Type;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseProperty extends Props {
    private final Type type;

    public void patchData(UrlPreviewPropertyData r1) {
    }

    public int hashCode() {
        return getType().hashCode();
    }

    public Type getType() {
        return this.type;
    }

    public BaseProperty(Type r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        this.type = r2;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.BaseProperty");
        if (getType() == ((BaseProperty) r4).getType()) goto L15;
        return false;
    L15:
        return true;
    L8:
        r2 = null;
        goto L10
    }
}
