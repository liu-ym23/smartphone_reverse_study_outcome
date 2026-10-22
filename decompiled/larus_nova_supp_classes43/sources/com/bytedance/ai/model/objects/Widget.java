package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import h5.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 R2\u00020\u0001:\u0001RBÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b\u001c\u0010 J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010I\u001a\u00020\u0003H\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020\u0019H\u0016J\u0018\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u0019H\u0016R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010%R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010%R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010%R$\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u00109\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010%R$\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010E\u001a\u00020\u00038BX\u0083\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bF\u0010\"¨\u0006S"}, d2 = {"Lcom/bytedance/ai/model/objects/Widget;", "Lcom/bytedance/ai/model/objects/AIPackage;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "packageName", "versionCode", "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB, "keywords", "", "appGroup", "widgetId", "entry", "input", "output", "border", "", "boxType", "", "titleType", "runtimeVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getWidgetId", "()Ljava/lang/String;", "getEntry", "setEntry", "(Ljava/lang/String;)V", "getInput", "setInput", "getOutput", "setOutput", "getBorder", "()Z", "setBorder", "(Z)V", "getBoxType", "()I", "setBoxType", "(I)V", "getTitleType", "()Ljava/lang/Integer;", "setTitleType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "template", "getTemplate$annotations", "()V", "getTemplate", "setTemplate", "botId", "getBotId$annotations", "getBotId", "setBotId", "appSettings", "getAppSettings", "()Ljava/util/List;", "setAppSettings", "(Ljava/util/List;)V", "internalUniqueId", "getInternalUniqueId", "internalUniqueId$delegate", "Lkotlin/Lazy;", BdpAwemeConstant.KEY_APP_ID, "getUniqueId", "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Widget extends AIPackage {
    public static final Parcelable.Creator<Widget> CREATOR = null;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final boolean O;
    public final int P;
    public final Integer Q;
    public final String R;
    public final String S;
    public List<String> T;
    public final transient Lazy U;

    public static final class a implements Parcelable.Creator<Widget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Widget createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Widget(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Widget[] newArray(int r1) {
            return new Widget[r1];
        }
    }

    public static final class b {
    }

    public Widget() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, 1048575);
    }

    @Override // com.bytedance.ai.model.objects.AIPackage, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String d() {
        return (String) this.U.getValue();
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String a() {
        return this.K;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final AIPackage.AIPackageType c() {
        return AIPackage.AIPackageType.WIDGET;
    }

    public Widget(Parcel r27) {
        Intrinsics.checkNotNullParameter(r27, "parcel");
        String r0 = r27.readString();
        if (r0 != null) goto L5;
        String r1 = "";
    L6:
        String r10 = r27.readString();
        if (r10 != null) goto L9;
        String r11 = "";
    L10:
        long r12 = r27.readLong();
        String r13 = r27.readString();
        String r14 = r27.readString();
        if (r14 != null) goto L13;
        String r15 = "";
    L14:
        String r16 = r27.readString();
        if (r16 != null) goto L17;
        String r17 = "";
    L18:
        Icons r18 = (Icons) r27.readParcelable(Icons.class.getClassLoader());
        String r19 = r27.readString();
        if (r19 != null) goto L21;
        String r20 = "";
    L22:
        String r21 = r27.readString();
        if (r21 != null) goto L25;
        String r110 = "";
    L26:
        String r22 = r27.readString();
        if (r22 != null) goto L29;
        String r111 = "";
    L30:
        ArrayList<String> r112 = r27.createStringArrayList();
        String r23 = r27.readString();
        if (r23 != null) goto L33;
        String r113 = "";
    L34:
        String r24 = r27.readString();
        if (r24 != null) goto L37;
        String r114 = "";
    L38:
        String r25 = r27.readString();
        if (r25 != null) goto L41;
        String r115 = "";
    L42:
        String r26 = r27.readString();
        if (r26 != null) goto L45;
        String r116 = "";
    L46:
        String r28 = r27.readString();
        if (r28 != null) goto L49;
        String r29 = "";
    L51:
        if (r27.readByte() == 0) goto L53;
        boolean r210 = true;
    L54:
        String r117 = r114;
        String r118 = r115;
        String r119 = r116;
        String r120 = r29;
        boolean r121 = r210;
        this(r1, r11, r12, r13, r15, r17, r18, r20, r110, r111, r112, r113, r117, r118, r119, r120, r121, r27.readInt(), Integer.valueOf(r27.readInt()), null, 524288);
        String r30 = r27.readString();
        if (r30 != null) goto L57;
        r30 = "";
    L57:
        this.R = r30;
        String r31 = r27.readString();
        if (r31 != null) goto L60;
        r31 = "";
    L60:
        this.S = r31;
        ArrayList<String> r32 = r27.createStringArrayList();
        if (r32 != null) goto L64;
        r32 = new ArrayList();
    L64:
        this.T = r32;
        h(r27);
        return;
    L53:
        r210 = false;
        goto L54
    L49:
        r29 = r28;
        goto L51
    L45:
        r116 = r26;
        goto L46
    L41:
        r115 = r25;
        goto L42
    L37:
        r114 = r24;
        goto L38
    L33:
        r113 = r23;
        goto L34
    L29:
        r111 = r22;
        goto L30
    L25:
        r110 = r21;
        goto L26
    L21:
        r20 = r19;
        goto L22
    L17:
        r17 = r16;
        goto L18
    L13:
        r15 = r14;
        goto L14
    L9:
        r11 = r10;
        goto L10
    L5:
        r1 = r0;
        goto L6
    }

    @Override // com.bytedance.ai.model.objects.AIPackage, android.os.Parcelable
    public final void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "dest");
        r10.writeString(this.a);
        r10.writeString(this.b);
        r10.writeLong(this.c);
        r10.writeString(this.d);
        r10.writeString(this.e);
        r10.writeString(this.f);
        r10.writeParcelable(this.g, r11);
        r10.writeString(this.h);
        r10.writeString(this.i);
        r10.writeString(this.j);
        r10.writeStringList(this.k);
        r10.writeString(this.l);
        r10.writeString(this.K);
        r10.writeString(this.L);
        r10.writeString(this.M);
        r10.writeString(this.N);
        r10.writeByte(this.O ? 1 : 0);
        r10.writeInt(this.P);
        Integer r0 = this.Q;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        r10.writeInt(r1);
        r10.writeString(this.R);
        r10.writeString(this.S);
        r10.writeStringList(this.T);
        super.writeToParcel(r10, r11);
        return;
    L5:
        r1 = -1;
        goto L6
    }

    public Widget(String r16, final String r17, long r18, String r20, String r21, String r22, Icons r23, String r24, String r25, String r26, List<String> r27, String r28, String r29, String r30, String r31, String r32, boolean r33, int r34, Integer r35, String r36) {
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r21, "versionName");
        Intrinsics.checkNotNullParameter(r22, "description");
        Intrinsics.checkNotNullParameter(r24, "manifestVersion");
        Intrinsics.checkNotNullParameter(r25, "prop");
        Intrinsics.checkNotNullParameter(r26, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
        Intrinsics.checkNotNullParameter(r28, "appGroup");
        Intrinsics.checkNotNullParameter(r29, "widgetId");
        Intrinsics.checkNotNullParameter(r30, "entry");
        Intrinsics.checkNotNullParameter(r31, "input");
        Intrinsics.checkNotNullParameter(r32, "output");
        Intrinsics.checkNotNullParameter(r36, "runtimeVersion");
        super(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        this.K = r29;
        this.L = r30;
        this.M = r31;
        this.N = r32;
        this.O = r33;
        this.P = r34;
        this.Q = r35;
        this.R = "";
        this.S = "";
        this.T = new ArrayList();
        this.U = LazyKt.lazy(new i(r17, this));
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        this.C = r36;
    }

    public /* synthetic */ Widget(String r24, String r25, long r26, String r28, String r29, String r30, Icons r31, String r32, String r33, String r34, List r35, String r36, String r37, String r38, String r39, String r40, boolean r41, int r42, Integer r43, String r44, int r45) {
        if ((r45 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r10 = "";
    L11:
        if ((r45 & 4) == 0) goto L13;
        long r11 = 0;
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r12 = "";
    L19:
        if ((r45 & 16) == 0) goto L21;
        String r13 = "";
    L23:
        if ((r45 & 32) == 0) goto L25;
        String r14 = "";
    L27:
        if ((r45 & 64) == 0) goto L29;
        Icons r15 = new Icons();
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r16 = "";
    L35:
        if ((r45 & 256) == 0) goto L37;
        String r17 = "";
    L39:
        if ((r45 & 512) == 0) goto L41;
        String r18 = "";
    L43:
        if ((r45 & 1024) == 0) goto L45;
        List r19 = new ArrayList();
    L47:
        if ((r45 & 2048) == 0) goto L49;
        String r110 = "";
    L51:
        if ((r45 & 4096) == 0) goto L53;
        String r111 = "";
    L54:
        String r112 = "";
        if ((r45 & 8192) == 0) goto L57;
        String r20 = r112;
    L58:
        String r113 = r20;
        if ((r45 & 16384) == 0) goto L61;
        String r21 = r112;
    L63:
        if ((r45 & 32768) == 0) goto L65;
        String r114 = r112;
    L66:
        int r22 = 0;
        if ((r45 & 65536) == 0) goto L69;
        boolean r115 = false;
    L71:
        if ((r45 & 131072) != 0) goto L75;
        r22 = r42;
    L75:
        if ((r45 & 262144) == 0) goto L77;
        Integer r23 = -1;
    L79:
        if ((r45 & 524288) != 0) goto L82;
        r112 = r44;
    L82:
        this(r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r113, r21, r114, r115, r22, r23, r112);
        return;
    L77:
        r23 = r43;
        goto L79
    L69:
        r115 = r41;
        goto L71
    L65:
        r114 = r40;
        goto L66
    L61:
        r21 = r39;
        goto L63
    L57:
        r20 = r38;
        goto L58
    L53:
        r111 = r37;
        goto L54
    L49:
        r110 = r36;
        goto L51
    L45:
        r19 = r35;
        goto L47
    L41:
        r18 = r34;
        goto L43
    L37:
        r17 = r33;
        goto L39
    L33:
        r16 = r32;
        goto L35
    L29:
        r15 = r31;
        goto L31
    L25:
        r14 = r30;
        goto L27
    L21:
        r13 = r29;
        goto L23
    L17:
        r12 = r28;
        goto L19
    L13:
        r11 = r26;
        goto L15
    L9:
        r10 = r25;
        goto L11
    L5:
        r1 = r24;
        goto L7
    }
}
