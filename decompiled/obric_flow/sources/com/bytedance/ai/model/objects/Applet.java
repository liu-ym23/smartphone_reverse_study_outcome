package com.bytedance.ai.model.objects;

import a2.a;
import a5.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Entity(tableName = "ai_applet_info")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/objects/Applet;", "Lcom/bytedance/ai/model/objects/AIPackage;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Applet extends AIPackage {

    @JvmField
    public static final Parcelable.Creator<Applet> CREATOR = null;
    public final String F;
    public final List G;
    public final List H;
    public final String I;
    public final String J;
    public final String K;
    public String L;
    public String M;
    public final ArrayList N;
    public String O;
    public MainInitData P;
    public List Q;
    public Map R;
    public final transient Lazy S;

    static {
        CREATOR = new b(19);
    }

    public Applet(String r15, String r16, long r17, String r19, String r20, String r21, Icons r22, String r23, String r24, String r25, List r26, String r27, String r28, List r29, List r30, String r31, String r32, String r33, String r34) {
        Intrinsics.checkNotNullParameter(r15, "name");
        Intrinsics.checkNotNullParameter(r16, "packageName");
        Intrinsics.checkNotNullParameter(r20, "versionName");
        Intrinsics.checkNotNullParameter(r21, Constant.DESCRIPTION);
        Intrinsics.checkNotNullParameter(r23, "manifestVersion");
        Intrinsics.checkNotNullParameter(r24, "prop");
        Intrinsics.checkNotNullParameter(r25, "recommend");
        Intrinsics.checkNotNullParameter(r27, "appGroup");
        Intrinsics.checkNotNullParameter(r28, "appletId");
        Intrinsics.checkNotNullParameter(r31, "botId");
        Intrinsics.checkNotNullParameter(r32, "appletEntry");
        Intrinsics.checkNotNullParameter(r34, "runtimeVersion");
        super(r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27);
        this.F = r28;
        this.G = r29;
        this.H = r30;
        this.I = r31;
        this.J = r32;
        this.K = r33;
        this.L = "";
        this.M = "";
        this.N = new ArrayList();
        this.O = "";
        this.Q = new ArrayList();
        this.R = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        this.C = r34;
        this.S = LazyKt.lazy(new a(5, r16, this));
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String c() {
        return this.F;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final AIPackage.AIPackageType e() {
        return AIPackage.AIPackageType.f2279a;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String f() {
        return (String) this.S.getValue();
    }

    public final String i() {
        String r5 = this.F;
        if (c.l(r5) == false) goto L6;
        return r5;
    L6:
        return this.f2258a;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage, android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.f2258a);
        r5.writeString(this.f2259b);
        r5.writeLong(this.f2260c);
        r5.writeString(this.d);
        r5.writeString(this.e);
        r5.writeString(this.f);
        r5.writeParcelable(this.g, r10);
        r5.writeString(this.f2261h);
        r5.writeString(this.f2262i);
        r5.writeString(this.f2263j);
        r5.writeStringList(this.f2264k);
        r5.writeString(this.f2265l);
        r5.writeString(this.F);
        r5.writeTypedList(this.G);
        r5.writeTypedList(this.H);
        r5.writeString(this.I);
        r5.writeString(this.J);
        r5.writeString(this.K);
        r5.writeString(this.L);
        r5.writeString(this.M);
        r5.writeString(this.O);
        r5.writeParcelable(this.P, r10);
        r5.writeTypedList(this.Q);
        super.writeToParcel(r5, r10);
    }
}
