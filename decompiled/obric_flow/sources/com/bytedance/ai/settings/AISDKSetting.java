package com.bytedance.ai.settings;

import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z0.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/settings/AISDKSetting;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", Constant.DESCRIPTION, "defaultValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "getName", "getType", "getValue", "()Ljava/lang/Object;", "getValueString", "getDefaultValueString", "isCustomType", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISDKSetting<T> {
    private final T defaultValue;
    private final String description;
    private final String name;
    private final Type type;

    public AISDKSetting(String r5, String r10, T r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        this.name = r5;
        this.description = r10;
        this.defaultValue = r11;
        Class<?> r12 = r11.getClass();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.ai.settings.AISDKSetting>");
        this.type = r12;
    }

    private final boolean isCustomType() {
        if (Intrinsics.areEqual(this.type, Boolean.TYPE) == false) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(this.type, Integer.class) == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.type, Integer.TYPE) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.type, Short.TYPE) == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.type, Float.TYPE) == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.type, Long.TYPE) == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, Double.TYPE) == false) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.type, String.class) == true) goto L28;
        return true;
    L28:
        return false;
    }

    public final String getDefaultValueString() {
        if (isCustomType() == false) goto L7;
        return c.c(this.defaultValue);
    L7:
        return this.defaultValue.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final Type getType() {
        return this.type;
    }

    public final T getValue() {
        String r5 = this.name;
        Type r10 = this.type;
        T r11 = this.defaultValue;
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        if (r11 == null) goto L5;
        return r11;
    L5:
        return this.defaultValue;
    }

    public final String getValueString() {
        T r5 = getValue();
        if (isCustomType() == false) goto L7;
        return c.c(r5);
    L7:
        return r5.toString();
    }

    public /* synthetic */ AISDKSetting(String r5, String r10, Object r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r10 = "";
    L8:
        this(r5, r10, r11);
    }
}
