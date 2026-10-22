package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001b\u0010\u001fJ6\u0010x\u001a\u00020y2$\u0010z\u001a \u0012\u0006\u0012\u0004\u0018\u00010|\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020y0{j\u0002`}2\b\b\u0002\u0010~\u001a\u00020]J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u007f\u001a\u00020\u0003H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020y2\u0007\u0010\u0086\u0001\u001a\u00020\u001e2\b\u0010\u0087\u0001\u001a\u00030\u0084\u0001H\u0016J\u0014\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010*R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010*R$\u00101\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010!\"\u0004\b5\u0010*R8\u00106\u001a\u0016\u0012\u0004\u0012\u000208\u0018\u000107j\n\u0012\u0004\u0012\u000208\u0018\u0001`98\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u00103\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u00103\u001a\u0004\bA\u0010!\"\u0004\bB\u0010*R$\u0010C\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u00103\u001a\u0004\bE\u0010!\"\u0004\bF\u0010*R$\u0010G\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bH\u00103\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010*R \u0010K\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010#\"\u0004\bT\u0010%R,\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020W\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020]8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010!\"\u0004\bd\u0010*R \u0010e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010!\"\u0004\bg\u0010*R \u0010h\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010o8G¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0011\u0010r\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\bs\u0010!R\u001b\u0010t\u001a\u00020\u00038BX\u0083\u0084\u0002¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bu\u0010!¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/ai/model/objects/Applet;", "Lcom/bytedance/ai/model/objects/AIPackage;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "packageName", "versionCode", "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB, "keywords", "", "appGroup", "appletId", "pages", "Lcom/bytedance/ai/model/objects/Page;", "plugins", "Lcom/bytedance/ai/model/objects/Plugin;", "botId", "appletEntry", "appRuntimeEntry", "runtimeVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppletId", "()Ljava/lang/String;", "getPages", "()Ljava/util/List;", "setPages", "(Ljava/util/List;)V", "getPlugins", "setPlugins", "getBotId", "setBotId", "(Ljava/lang/String;)V", "getAppletEntry", "setAppletEntry", "getAppRuntimeEntry", "botDevMode", "getBotDevMode", "setBotDevMode", "version", "getVersion$annotations", "()V", "getVersion", "setVersion", "widgets", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Widget;", "Lkotlin/collections/ArrayList;", "getWidgets$annotations", "getWidgets", "()Ljava/util/ArrayList;", "setWidgets", "(Ljava/util/ArrayList;)V", "entry", "getEntry$annotations", "getEntry", "setEntry", "appletDirName", "getAppletDirName$annotations", "getAppletDirName", "setAppletDirName", "channelName", "getChannelName$annotations", "getChannelName", "setChannelName", "mainInit", "Lcom/bytedance/ai/model/objects/MainInitData;", "getMainInit", "()Lcom/bytedance/ai/model/objects/MainInitData;", "setMainInit", "(Lcom/bytedance/ai/model/objects/MainInitData;)V", "services", "Lcom/bytedance/ai/model/objects/ServiceInfo;", "getServices", "setServices", "permissions", "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "darkMode", "", "getDarkMode", "()Z", "setDarkMode", "(Z)V", "chat", "getChat", "setChat", "toolRuntimeEntry", "getToolRuntimeEntry", "setToolRuntimeEntry", "settings", "Lcom/bytedance/ai/model/objects/AppletSettings;", "getSettings", "()Lcom/bytedance/ai/model/objects/AppletSettings;", "setSettings", "(Lcom/bytedance/ai/model/objects/AppletSettings;)V", "chatConfig", "Lcom/bytedance/ai/model/objects/AppletChatConfig;", "getChatConfig", "()Lcom/bytedance/ai/model/objects/AppletChatConfig;", "homePath", "getHomePath", "internalUniqueId", "getInternalUniqueId", "internalUniqueId$delegate", "Lkotlin/Lazy;", "loadMainJS", "", "callback", "Lkotlin/Function3;", "Lcom/bytedance/ai/utils/ResponseData;", "Lcom/bytedance/ai/utils/LoadGeckoCallback;", "forRts", "getUniqueId", BdpAwemeConstant.KEY_APP_ID, "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "describeContents", "", "writeToParcel", "dest", "flags", "findPageByUrl", com.bytedance.android.ec.core.event.a.KEY_URL, "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Applet extends AIPackage {
    public static final Parcelable.Creator<Applet> CREATOR = null;
    public final String K;
    public final List<Page> L;
    public final List<Plugin> M;
    public final String N;
    public final String O;
    public final String P;
    public String Q;
    public final String R;
    public ArrayList<Widget> S;
    public final String T;
    public MainInitData U;
    public List<ServiceInfo> V;
    public Map<String, PermissionDetail> W;
    public boolean X;
    public String Y;
    public String Z;
    public AppletSettings k0;
    public final transient Lazy p0;

    public static final class a implements Parcelable.Creator<Applet> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Applet createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Applet(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Applet[] newArray(int r1) {
            return new Applet[r1];
        }
    }

    public static final class b {
    }

    public Applet() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287);
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
        return (String) this.p0.getValue();
    }

    public final String o() {
        if (f.g(this.K) == false) goto L7;
        return this.K;
    L7:
        return this.a;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String a() {
        return this.K;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final AIPackage.AIPackageType c() {
        return AIPackage.AIPackageType.APPLET;
    }

    public Applet(Parcel r25) {
        Intrinsics.checkNotNullParameter(r25, "parcel");
        String r0 = r25.readString();
        String r21 = "";
        if (r0 != null) goto L5;
        String r1 = "";
    L6:
        String r10 = r25.readString();
        if (r10 != null) goto L9;
        String r11 = "";
    L10:
        long r12 = r25.readLong();
        String r13 = r25.readString();
        String r14 = r25.readString();
        if (r14 != null) goto L13;
        String r15 = "";
    L14:
        String r16 = r25.readString();
        if (r16 != null) goto L17;
        String r17 = "";
    L18:
        Icons r18 = (Icons) r25.readParcelable(Icons.class.getClassLoader());
        String r19 = r25.readString();
        if (r19 != null) goto L21;
        String r20 = "";
    L22:
        String r22 = r25.readString();
        if (r22 != null) goto L25;
        String r110 = "";
    L26:
        String r23 = r25.readString();
        if (r23 != null) goto L29;
        String r111 = "";
    L30:
        ArrayList<String> r112 = r25.createStringArrayList();
        String r24 = r25.readString();
        if (r24 != null) goto L33;
        String r113 = "";
    L34:
        String r26 = r25.readString();
        if (r26 != null) goto L37;
        String r114 = "";
    L38:
        ArrayList r115 = r25.createTypedArrayList(Page.CREATOR);
        ArrayList r116 = r25.createTypedArrayList(Plugin.CREATOR);
        String r27 = r25.readString();
        if (r27 != null) goto L41;
        String r117 = "";
    L42:
        String r28 = r25.readString();
        if (r28 != null) goto L45;
        String r29 = "";
    L46:
        String r30 = r25.readString();
        if (r30 != null) goto L49;
        String r210 = "";
    L50:
        this(r1, r11, r12, r13, r15, r17, r18, r20, r110, r111, r112, r113, r114, r115, r116, r117, r29, r210, 262144);
        String r31 = r25.readString();
        if (r31 != null) goto L53;
        r31 = "";
    L53:
        this.Q = r31;
        String r32 = r25.readString();
        if (r32 != null) goto L56;
        r32 = "";
    L56:
        this.R = r32;
        String r33 = r25.readString();
        if (r33 != null) goto L59;
        r33 = "";
    L59:
        this.T = r33;
        this.U = (MainInitData) r25.readParcelable(MainInitData.class.getClassLoader());
        this.V = r25.createTypedArrayList(ServiceInfo.CREATOR);
        h(r25);
        if (r25.readByte() != 0) goto L64;
        boolean r34 = false;
    L65:
        this.X = r34;
        AppletSettings r35 = null;
        String r36 = r25.readString();     // Catch: Exception -> L68
    L69:
        this.Y = r36;
        r21 = r25.readString();     // Catch: Exception -> L76
    L71:
        this.Z = r21;
        r35 = (AppletSettings) r25.readParcelable(AppletSettings.class.getClassLoader());     // Catch: Exception -> L77
    L74:
        this.k0 = r35;
        return;
    L68:
        r36 = null;
    L64:
        r34 = true;
        goto L65
    L49:
        r210 = r30;
        goto L50
    L45:
        r29 = r28;
        goto L46
    L41:
        r117 = r27;
        goto L42
    L37:
        r114 = r26;
        goto L38
    L33:
        r113 = r24;
        goto L34
    L29:
        r111 = r23;
        goto L30
    L25:
        r110 = r22;
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

    public final Page q(String r10) {
        Object r0 = null;
        if (r10 == null) goto L27;
        String r11 = c.a(r10);
        if (r11 == null) goto L28;
        List<Page> r1 = this.L;
        if (r1 == null) goto L29;
        Iterator<T> r12 = r1.iterator();
    L10:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();
        Page r14 = (Page) r13;
        if (Intrinsics.areEqual(r14.getPath(), r11) == false) goto L14;
    L17:
        boolean r15 = true;
    L18:
        if (r15 == false) goto L10;
        r0 = r13;
        goto L21
    L14:
        if (Intrinsics.areEqual(r14.pageId(), r11) == true) goto L17;
        r15 = false;
    L21:
        return (Page) r0;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }

    public final void r(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.Q = r10;
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
        r10.writeTypedList(this.L);
        r10.writeTypedList(this.M);
        r10.writeString(this.N);
        r10.writeString(this.O);
        r10.writeString(this.P);
        r10.writeString(this.Q);
        r10.writeString(this.R);
        r10.writeString(this.T);
        r10.writeParcelable(this.U, r11);
        r10.writeTypedList(this.V);
        super.writeToParcel(r10, r11);
        r10.writeByte(this.X ? 1 : 0);
        r10.writeString(this.Y);
        r10.writeString(this.Z);
        r10.writeParcelable(this.k0, r11);
    }

    public /* synthetic */ Applet(String r25, String r26, long r27, String r29, String r30, String r31, Icons r32, String r33, String r34, String r35, List r36, String r37, String r38, List r39, List r40, String r41, String r42, String r43, int r44) {
        String r10 = "";
        if ((r44 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r44 & 4) == 0) goto L13;
        long r13 = 0;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r14 = "";
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r15 = "";
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r16 = "";
    L27:
        if ((r44 & 64) == 0) goto L29;
        Icons r17 = new Icons();
    L31:
        if ((r44 & 128) == 0) goto L33;
        String r18 = "";
    L35:
        if ((r44 & 256) == 0) goto L37;
        String r19 = "";
    L39:
        if ((r44 & 512) == 0) goto L41;
        String r110 = "";
    L43:
        if ((r44 & 1024) == 0) goto L45;
        List r111 = new ArrayList();
    L47:
        if ((r44 & 2048) == 0) goto L49;
        String r112 = "";
    L51:
        if ((r44 & 4096) == 0) goto L53;
        String r113 = "";
    L55:
        if ((r44 & 8192) == 0) goto L57;
        List r114 = new ArrayList();
    L59:
        if ((r44 & 16384) == 0) goto L61;
        List r115 = new ArrayList();
    L63:
        if ((32768 & r44) == 0) goto L65;
        String r20 = "";
    L67:
        if ((65536 & r44) == 0) goto L69;
        String r21 = "";
    L71:
        if ((131072 & r44) == 0) goto L73;
        String r22 = "";
    L75:
        if ((r44 & 262144) != 0) goto L78;
        r10 = null;
    L78:
        this(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r10);
        return;
    L73:
        r22 = r43;
        goto L75
    L69:
        r21 = r42;
        goto L71
    L65:
        r20 = r41;
        goto L67
    L61:
        r115 = r40;
        goto L63
    L57:
        r114 = r39;
        goto L59
    L53:
        r113 = r38;
        goto L55
    L49:
        r112 = r37;
        goto L51
    L45:
        r111 = r36;
        goto L47
    L41:
        r110 = r35;
        goto L43
    L37:
        r19 = r34;
        goto L39
    L33:
        r18 = r33;
        goto L35
    L29:
        r17 = r32;
        goto L31
    L25:
        r16 = r31;
        goto L27
    L21:
        r15 = r30;
        goto L23
    L17:
        r14 = r29;
        goto L19
    L13:
        r13 = r27;
        goto L15
    L9:
        r12 = r26;
        goto L11
    L5:
        r11 = r25;
        goto L7
    }

    public Applet(String r15, final String r16, long r17, String r19, String r20, String r21, Icons r22, String r23, String r24, String r25, List<String> r26, String r27, String r28, List<Page> r29, List<Plugin> r30, String r31, String r32, String r33, String r34) {
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r16, "packageName");
        Intrinsics.checkNotNullParameter(r20, "versionName");
        Intrinsics.checkNotNullParameter(r21, "description");
        Intrinsics.checkNotNullParameter(r23, "manifestVersion");
        Intrinsics.checkNotNullParameter(r24, "prop");
        Intrinsics.checkNotNullParameter(r25, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
        Intrinsics.checkNotNullParameter(r27, "appGroup");
        Intrinsics.checkNotNullParameter(r28, "appletId");
        Intrinsics.checkNotNullParameter(r31, "botId");
        Intrinsics.checkNotNullParameter(r32, "appletEntry");
        Intrinsics.checkNotNullParameter(r34, "runtimeVersion");
        super(r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27);
        this.K = r28;
        this.L = r29;
        this.M = r30;
        this.N = r31;
        this.O = r32;
        this.P = r33;
        this.Q = "";
        this.R = "";
        this.S = new ArrayList();
        this.T = "";
        this.V = new ArrayList();
        this.W = new LinkedHashMap();
        this.X = true;
        this.Z = "";
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        this.C = r34;
        this.p0 = LazyKt.lazy(new h5.a(r16, this));
    }
}
