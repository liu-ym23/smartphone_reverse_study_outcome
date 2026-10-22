package com.obric.oui.material;

import android.graphics.Color;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001fJ'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010*\u001a\u00020\u0004H\u0007J\u001a\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0007J%\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u001d\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0002\u0010%J\u001a\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001b\u00101\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\u00103J\u0016\u00104\u001a\u0004\u0018\u00010$*\u0002052\u0006\u00106\u001a\u00020\u0004H\u0002J\u0016\u00107\u001a\u0004\u0018\u00010\u0004*\u0002052\u0006\u00106\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/material/MaterialConfigBuilder;", "", "()V", "QUERY_COLUMN_SERIALIZATION_FORMAT", "", "QUERY_COLUMN_SERIALIZED_CONFIG_ARRAY", "SERIALIZATION_FORMAT_BINARY", "SERIALIZATION_FORMAT_JSON", "SERIALIZATION_FORMAT_XML", "arrayFromJson", "", "Lcom/obric/oui/material/MaterialConfig;", "json", "(Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "arrayFromJsonFile", "file", "Ljava/io/File;", "(Ljava/io/File;)[Lcom/obric/oui/material/MaterialConfig;", "arrayFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "createBlendConfigFromColorful", "Lcom/obric/oui/color/BlendConfig;", TypedValues.Custom.S_COLOR, "", "(I)[Lcom/obric/oui/color/BlendConfig;", "createSimpleColorful", "baseConfig", "(Lcom/obric/oui/material/MaterialConfig;I)[Lcom/obric/oui/material/MaterialConfig;", "baseConfigs", "([Lcom/obric/oui/material/MaterialConfig;I)[Lcom/obric/oui/material/MaterialConfig;", "deserializeFromByteArray", "payload", "", "([B)[Lcom/obric/oui/material/MaterialConfig;", "fromJson", "fromJsonFile", "fromUri", "fromXml", Params.FILE_PATH, "dirPath", "fileName", "parseJsonFromUri", "parseXmlPayload", "querySerializedPayload", "Lcom/obric/oui/material/MaterialConfigBuilder$SerializedQueryResult;", "serializeToByteArray", "configs", "([Lcom/obric/oui/material/MaterialConfig;)[B", "getBlobOrNull", "Landroid/database/Cursor;", "columnName", "getStringOrNull", "SerializedQueryResult", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14017a = null;

    static {
        f14017a = new d();
    }

    private d() {
    }

    public final com.obric.oui.color.a[] a(int r4) {
        return new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, BlendMode.SRC_OVER), new com.obric.oui.color.a(-3355444, BlendMode.OVERLAY), new com.obric.oui.color.a(r4, BlendMode.PLUS_DARKER)};
    }

    public final c[] a(c[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "baseConfigs");
        int r9 = com.obric.oui.color.d.a(r11, 0.1f);
        int r12 = Color.argb(102, Color.red(r9), Color.green(r9), Color.blue(r9));
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r10.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        c r5 = r10[r4];
        c r6 = r5.l();
        r6.a(f14017a.a(r9));
        com.obric.oui.color.e r7 = r5.e();
        if (r7 != null) goto L7;
        com.obric.oui.color.e r8 = null;
    L8:
        r6.a(r8);
        r0.add(r6);
        r4 = r4 + 1;
        goto L3
    L7:
        r8 = new com.obric.oui.color.e(r7.a(), r12, r7.c());
        goto L8
    L9:
        Object[] r13 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (c[]) ZeusTransformUtils.preCheckCast(r13, c[].class, "com.obric.memorydata.plugin");
    }
}
