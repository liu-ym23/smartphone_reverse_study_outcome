package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u008d\u00012\u00020\u0001:\n\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0016J\u0010\u0010{\u001a\u00020|2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010}\u001a\u00020|2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010~\u001a\u00020HH\u0016J\b\u0010\u007f\u001a\u00020HH\u0016J\t\u0010\u0080\u0001\u001a\u00020|H\u0016J\t\u0010\u0081\u0001\u001a\u00020|H\u0016J\u0010\u0010\u0082\u0001\u001a\u00020|2\u0007\u0010\u0083\u0001\u001a\u00020HJ\u0007\u0010\u0084\u0001\u001a\u00020XJ\u0010\u0010\u0085\u0001\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020zJ\t\u0010\u0087\u0001\u001a\u00020\u0003H&J\t\u0010\u0088\u0001\u001a\u00020\u0003H&J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H&J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010\u008c\u0001\u001a\u00020XR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001e\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010.R\u001e\u00102\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010*R\u001e\u00105\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010*R\u001e\u00108\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010*R\u001e\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010*R\u001e\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010*R\u001e\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010*R\u001e\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010.R\"\u0010G\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010N\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010.R\u001e\u0010Q\u001a\u00020R8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020X8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020X8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R \u0010^\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0018\"\u0004\b`\u0010.R\u001e\u0010a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0018\"\u0004\bc\u0010.R\u001e\u0010d\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\u001e\u0010l\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR\u001e\u0010o\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010f\"\u0004\bq\u0010hR\u001e\u0010r\u001a\u00020s8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010y8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage;", "Landroid/os/Parcelable;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "packageName", "versionCode", "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB, "keywords", "", "appGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "getPackageName", "getVersionCode", "()J", "getScmVersion", "getVersionName", "getDescription", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "getManifestVersion", "getProp", "getRecommend", "getKeywords", "()Ljava/util/List;", "getAppGroup", "id", "getId", "setId", "(J)V", "digest", "getDigest", "setDigest", "(Ljava/lang/String;)V", "renderType", "getRenderType", "setRenderType", "size", "getSize", "setSize", "ft", "getFt", "setFt", "it", "getIt", "setIt", "ut", "getUt", "setUt", "updateTime", "getUpdateTime", "setUpdateTime", "createTime", "getCreateTime", "setCreateTime", "installStatus", "getInstallStatus", "setInstallStatus", "readyForDeleting", "", "getReadyForDeleting", "()Ljava/lang/Integer;", "setReadyForDeleting", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sessionId", "getSessionId", "setSessionId", com.bytedance.android.ec.core.event.a.KEY_STATUS, "Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "getStatus", "()Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "setStatus", "(Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;)V", "isPermanent", "", "()Z", "setPermanent", "(Z)V", "isDebug", "setDebug", "resFrom", "getResFrom", "setResFrom", "runtimeVersion", "getRuntimeVersion", "setRuntimeVersion", "hasKeyStore", "getHasKeyStore", "()I", "setHasKeyStore", "(I)V", "verifySignature", "getVerifySignature", "setVerifySignature", "appType", "getAppType", "setAppType", "sourceType", "getSourceType", "setSourceType", "useCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getUseCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setUseCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "useCountListener", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ai/model/objects/AIPackage$IUseCountChangedListener;", "readFromParcel", "", "writeToParcel", "flags", "describeContents", "markInUse", "markOutOfUse", "resetUseCount", "count", "isRunning", "setUseCountListener", "listener", "getUniqueId", BdpAwemeConstant.KEY_APP_ID, "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "getIconUrl", "isInternalApp", "Companion", "AIPackageType", "PackageStatus", "ResFrom", "IUseCountChangedListener", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AIPackage implements Parcelable {
    public static final /* synthetic */ int J = 0;
    public boolean A;
    public String B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public final AtomicInteger H;
    public transient WeakReference<b> I;
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final String f;
    public final Icons g;
    public final String h;
    public final String i;
    public final String j;
    public final List<String> k;
    public final String l;
    public long m;
    public String n;
    public String o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public String v;
    public Integer w;
    public String x;
    public PackageStatus y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "", "<init>", "(Ljava/lang/String;I)V", "APPLET", "WIDGET", "UNKNOWN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AIPackageType extends Enum<AIPackageType> {
        public static final AIPackageType APPLET = null;
        public static final AIPackageType UNKNOWN = null;
        public static final AIPackageType WIDGET = null;
        public static final /* synthetic */ AIPackageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AIPackageType> getEntries() {
            return b;
        }

        static {
            AIPackageType r0 = new AIPackageType("APPLET", 0);
            APPLET = r0;
            AIPackageType r1 = new AIPackageType("WIDGET", 1);
            WIDGET = r1;
            AIPackageType r10 = new AIPackageType("UNKNOWN", 2);
            UNKNOWN = r10;
            AIPackageType[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static AIPackageType[] values() {
            return (AIPackageType[]) a.clone();
        }

        public static AIPackageType valueOf(String r1) {
            return (AIPackageType) r27.a.a(AIPackageType.class, r1);
        }

        public AIPackageType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "UPDATING", "INSTALLING", "DELETING", "BASE_READY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PackageStatus extends Enum<PackageStatus> {
        public static final PackageStatus BASE_READY = null;
        public static final PackageStatus DELETING = null;
        public static final PackageStatus INSTALLING = null;
        public static final PackageStatus READY = null;
        public static final PackageStatus UPDATING = null;
        public static final /* synthetic */ PackageStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PackageStatus> getEntries() {
            return b;
        }

        static {
            PackageStatus r0 = new PackageStatus("READY", 0);
            READY = r0;
            PackageStatus r1 = new PackageStatus("UPDATING", 1);
            UPDATING = r1;
            PackageStatus r10 = new PackageStatus("INSTALLING", 2);
            INSTALLING = r10;
            PackageStatus r11 = new PackageStatus("DELETING", 3);
            DELETING = r11;
            PackageStatus r12 = new PackageStatus("BASE_READY", 4);
            BASE_READY = r12;
            PackageStatus[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static PackageStatus[] values() {
            return (PackageStatus[]) a.clone();
        }

        public static PackageStatus valueOf(String r1) {
            return (PackageStatus) r27.a.a(PackageStatus.class, r1);
        }

        public PackageStatus(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public static String a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
            return "pkg:" + r10 + "_id:" + r11;
        }
    }

    public interface b {
        void a(String r1, String r10);

        void b(String r1, String r10);
    }

    static {
    }

    public abstract String a();

    public abstract AIPackageType c();

    public abstract String d();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AIPackage() {
        this("", "", 0, "", "", "", new Icons(), "", "", "", new ArrayList(), "");
    }

    public final String b() {
        Icons r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.get3x();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Icons r10 = this.g;
        if (r10 == null) goto L9;
        String r11 = r10.get2x();
    L10:
        if (r11 != null) goto L17;
        Icons r12 = this.g;
        if (r12 == null) goto L15;
        return r12.get1x();
    L15:
        return null;
    L17:
        return r11;
    L9:
        r11 = null;
        goto L10
    }

    public void e() {
        this.H.incrementAndGet();
        g.a.d("AIManager", "-------AIPackage " + c() + ' ' + hashCode() + ": " + this.b + ' ' + a() + " markInUse: " + this.H.get());
        WeakReference<b> r0 = this.I;
        if (r0 == null) goto L8;
        b r1 = r0.get();
        if (r1 == null) goto L9;
        r1.a(this.b, a());
        return;
    L9:
        return;
    }

    public void g() {
        this.H.decrementAndGet();
        g.a.d("AIManager", "-------AIPackage " + c() + ' ' + hashCode() + ": " + this.b + ' ' + a() + " markOutOfUse: " + this.H.get());
        WeakReference<b> r0 = this.I;
        if (r0 == null) goto L8;
        b r1 = r0.get();
        if (r1 == null) goto L9;
        r1.b(this.b, a());
        return;
    L9:
        return;
    }

    public final void h(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this.m = r10.readLong();
        String r1 = r10.readString();
        String r11 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.n = r1;
        String r12 = r10.readString();
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        this.o = r12;
        this.p = r10.readLong();
        this.q = r10.readLong();
        this.r = r10.readLong();
        this.s = r10.readLong();
        this.t = r10.readLong();
        this.u = r10.readLong();
        String r13 = r10.readString();
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        this.v = r13;
        this.w = Integer.valueOf(r10.readInt());
        this.x = r10.readString();
        this.y = PackageStatus.values()[r10.readInt()];
        boolean r14 = true;
        int r15 = 0;
        if (r10.readByte() == 0) goto L14;
        boolean r16 = true;
    L15:
        this.z = r16;
        if (r10.readByte() != 0) goto L19;
        r14 = false;
    L19:
        this.A = r14;
        this.B = r10.readString();
        String r17 = r10.readString();     // Catch: Exception -> L24
        if (r17 == null) goto L26;
        r11 = r17;
    L26:
        this.C = r11;
        int r18 = r10.readInt();     // Catch: Exception -> L29
    L31:
        this.D = r18;
        r15 = r10.readInt();     // Catch: Exception -> L34
    L36:
        this.E = r15;
        int r19 = r10.readInt();     // Catch: Exception -> L39
    L41:
        this.F = r19;
        int r20 = r10.readInt();     // Catch: Exception -> L44
    L46:
        this.G = r20;
        return;
    L44:
        e = move-exception;
        g.a.d("AIPackage", "read sourceType from parcel exception: " + e);
        r20 = 2;
    L39:
        e = move-exception;
        g.a.d("AIPackage", "read appType from parcel exception: " + e);
        r19 = CastIntegerProtector.parseInt("1");
    L34:
        e = move-exception;
        g.a.d("AIPackage", "read verifySignature from parcel exception: " + e);
    L29:
        e = move-exception;
        g.a.d("AIPackage", "read hasKeyStore from parcel exception: " + e);
        r18 = 0;
    L24:
        e = move-exception;
        g.a.d("AIPackage", "read runtimeVersion from parcel exception: " + e);
        goto L26
    L14:
        r16 = false;
        goto L15
    }

    public final void i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.n = r10;
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.v = r10;
    }

    public final void k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.o = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeLong(this.m);
        r10.writeString(this.n);
        r10.writeString(this.o);
        r10.writeLong(this.p);
        r10.writeLong(this.q);
        r10.writeLong(this.r);
        r10.writeLong(this.s);
        r10.writeLong(this.t);
        r10.writeLong(this.u);
        r10.writeString(this.v);
        Integer r12 = this.w;
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
    L6:
        r10.writeInt(r13);
        r10.writeString(this.x);
        r10.writeInt(this.y.ordinal());
        r10.writeByte(this.z ? 1 : 0);
        r10.writeByte(this.A ? 1 : 0);
        r10.writeString(this.B);
        r10.writeString(this.C);
        r10.writeInt(this.D);
        r10.writeInt(this.E);
        r10.writeInt(this.F);
        r10.writeInt(this.G);
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public AIPackage(String r10, String r11, long r12, String r13, String r14, String r15, Icons r16, String r17, String r18, String r19, List<String> r110, String r111) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r14, "versionName");
        Intrinsics.checkNotNullParameter(r15, "description");
        Intrinsics.checkNotNullParameter(r17, "manifestVersion");
        Intrinsics.checkNotNullParameter(r18, "prop");
        Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
        Intrinsics.checkNotNullParameter(r111, "appGroup");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.n = "";
        this.o = "";
        this.v = "";
        this.w = 0;
        this.y = PackageStatus.READY;
        this.C = "";
        this.F = CastIntegerProtector.parseInt("1");
        this.G = 2;
        this.H = new AtomicInteger(0);
    }
}
