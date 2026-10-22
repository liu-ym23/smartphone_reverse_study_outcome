package com.bytedance.ai.model.objects;

import a2.a;
import a5.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import cn.nubia.neopush.commons.Constant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Entity(tableName = "ai_widget_info")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/objects/Widget;", "Lcom/bytedance/ai/model/objects/AIPackage;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Widget extends AIPackage {

    @JvmField
    public static final Parcelable.Creator<Widget> CREATOR = null;
    public final String F;
    public final String G;
    public final String H;
    public final String I;
    public final boolean J;
    public final int K;
    public final Integer L;
    public String M;
    public String N;
    public ArrayList O;
    public final transient Lazy P;

    static {
        CREATOR = new b(20);
    }

    public /* synthetic */ Widget(String r25, String r26, long r27, String r29, String r30, String r31, Icons r32, String r33, String r34, String r35, List r36, String r37, String r38, String r39, String r40, String r41, boolean r42, int r43, Integer r44, String r45, int r46) {
        if ((r46 & 8) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r46 & 524288) == 0) goto L9;
        String r23 = "";
    L10:
        this(r25, r26, r27, r10, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r23);
        return;
    L9:
        r23 = r45;
        goto L10
    L5:
        r10 = r29;
        goto L7
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
        return AIPackage.AIPackageType.f2280b;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String f() {
        return (String) this.P.getValue();
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
        r5.writeString(this.G);
        r5.writeString(this.H);
        r5.writeString(this.I);
        r5.writeByte(this.J ? 1 : 0);
        r5.writeInt(this.K);
        Integer r11 = this.L;
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
    L6:
        r5.writeInt(r12);
        r5.writeString(this.M);
        r5.writeString(this.N);
        r5.writeStringList(this.O);
        super.writeToParcel(r5, r10);
        return;
    L5:
        r12 = -1;
        goto L6
    }

    public Widget(String r16, String r17, long r18, String r20, String r21, String r22, Icons r23, String r24, String r25, String r26, List r27, String r28, String r29, String r30, String r31, String r32, boolean r33, int r34, Integer r35, String r36) {
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r21, "versionName");
        Intrinsics.checkNotNullParameter(r22, Constant.DESCRIPTION);
        Intrinsics.checkNotNullParameter(r24, "manifestVersion");
        Intrinsics.checkNotNullParameter(r25, "prop");
        Intrinsics.checkNotNullParameter(r26, "recommend");
        Intrinsics.checkNotNullParameter(r28, "appGroup");
        Intrinsics.checkNotNullParameter(r29, "widgetId");
        Intrinsics.checkNotNullParameter(r30, "entry");
        Intrinsics.checkNotNullParameter(r31, "input");
        Intrinsics.checkNotNullParameter(r32, "output");
        Intrinsics.checkNotNullParameter(r36, "runtimeVersion");
        super(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        this.F = r29;
        this.G = r30;
        this.H = r31;
        this.I = r32;
        this.J = r33;
        this.K = r34;
        this.L = r35;
        this.M = "";
        this.N = "";
        this.O = new ArrayList();
        this.P = LazyKt.lazy(new a(6, r17, this));
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        this.C = r36;
    }
}
