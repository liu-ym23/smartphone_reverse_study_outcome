package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001SB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010G\u001a\u00020\u0004H\u0016J/\u0010H\u001a\u00020I2\b\u0010\u0005\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\tH\u0016J\u0018\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006T"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult;", ExifInterface.LONGITUDE_EAST, "Landroid/os/Parcelable;", "ret", "", "entity", "view", "Lcom/obric/capabilitykit/common/CardView;", "details", "", "inquireFurther", "", "needToSummarize", "uiType", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "floatingIntentParams", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(ILjava/lang/Object;Lcom/obric/capabilitykit/common/CardView;Ljava/lang/String;ZZILandroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", EventBody.KEY_VALUE, "getEntity", "()Ljava/lang/Object;", "setEntity", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "entityWrittenToFallbackOnly", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFloatingIntentParams", "()Lcom/obric/capabilitykit/common/FloatingIntentParams;", "setFloatingIntentParams", "(Lcom/obric/capabilitykit/common/FloatingIntentParams;)V", "getInquireFurther", "()Z", "setInquireFurther", "(Z)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isFinal", "setFinal", "isParcelableArray", "getNeedToSummarize", "setNeedToSummarize", "remoteCard", "Lcom/obric/capabilitykit/common/RemoteCard;", "getRemoteCard", "()Lcom/obric/capabilitykit/common/RemoteCard;", "setRemoteCard", "(Lcom/obric/capabilitykit/common/RemoteCard;)V", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "getView$annotations", "()V", "getView", "()Lcom/obric/capabilitykit/common/CardView;", "setView", "(Lcom/obric/capabilitykit/common/CardView;)V", "describeContents", "putEntityFallback", "", "", "elementClassName", "array", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentResult<E> implements Parcelable {
    public static final b CREATOR = null;
    private static final int FLAG_INQUIRE_FURTHER = 1;
    private static final int FLAG_NEED_TO_SUMMARIZE = 2;
    public static final String KEY_ENTITY_FALLBACK_JSON = "__entity_fallback_json_v1__";
    public static final String KEY_ENTITY_FALLBACK_TYPE = "__entity_fallback_type_v1__";
    private static final int PARCELABLE = 0;
    private static final int PARCELABLE_ARRAY = 1;
    private static final String TAG = "IntentResult";
    private static final Lazy<Gson> sGson$delegate = null;
    private String details;
    private E entity;
    private transient boolean entityWrittenToFallbackOnly;
    private ConcurrentHashMap<String, String> ext;
    private FloatingIntentParams floatingIntentParams;
    private boolean inquireFurther;
    private Intent intent;
    public boolean isFinal;
    private boolean needToSummarize;
    public RemoteCard remoteCard;
    private int ret;
    private int uiType;
    private CardView view;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", ExifInterface.LONGITUDE_EAST, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7505a = null;

        static {
            f7505a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ Gson invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "()V", "FLAG_INQUIRE_FURTHER", "", "FLAG_NEED_TO_SUMMARIZE", "KEY_ENTITY_FALLBACK_JSON", "", "KEY_ENTITY_FALLBACK_TYPE", "PARCELABLE", "PARCELABLE_ARRAY", "TAG", "sGson", "Lcom/google/gson/Gson;", "getSGson", "()Lcom/google/gson/Gson;", "sGson$delegate", "Lkotlin/Lazy;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/common/intent/IntentResult;", "resolveEntityFromFallback", "", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<IntentResult<?>> {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final Gson a() {
            return (Gson) ZeusTransformUtils.preCheckCast(IntentResult.access$getSGson$delegate$cp().getValue(), Gson.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ Gson a(b r0) {
            return r0.a();
        }

        private final Object a(ConcurrentHashMap<String, String> r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            String r2 = (String) ZeusTransformUtils.preCheckCast(r8.get(IntentResult.KEY_ENTITY_FALLBACK_JSON), String.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L40;
            boolean r5 = true;
            if (r2.length() <= 0) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == true) goto L14;
            r2 = null;
        L14:
            if (r2 == null) goto L43;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get(IntentResult.KEY_ENTITY_FALLBACK_TYPE), String.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L19;
            return null;
        L19:
            if (r9.length() > 0) goto L22;
            r5 = false;
        L22:
            if (r5 == true) goto L25;
            r9 = null;
        L25:
            if (r9 != null) goto L39;
            return null;
        L39:
            boolean r4 = StringsKt.endsWith$default(r9, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, null);     // Catch: Throwable -> L36
            if (r4 == false) goto L31;
            r9 = StringsKt.removeSuffix(r9, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);     // Catch: Throwable -> L36
        L31:
            Class r10 = ZeusTransformUtils.forName(r9, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
            if (r4 == false) goto L34;
            Object r7 = a().fromJson(r2, Array.newInstance(r10, 0).getClass());     // Catch: Throwable -> L36
        L42:
            return r7;
        L34:
            r7 = a().fromJson(r2, r10);     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            Log.w(IntentResult.TAG, "resolveEntityFromFallback failed (silent): " + th.getMessage());
            return null;
        L43:
            return null;
        L10:
            r3 = false;
            goto L11
        L40:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.os.Parcelable] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v5, types: [android.os.Parcelable[]] */
        public IntentResult<?> a(Parcel r17) {
            int r1 = r17.readInt();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            int r4 = r17.readInt();
            if (r17.readInt() != 1) goto L7;
            int r2 = r17.readInt();
            ?? r5 = new Parcelable[r2];
            int r6 = 0;
        L5:
            if (r6 >= r2) goto L8;
            r5[r6] = r17.readParcelable(IntentResult.class.getClassLoader());
            r6 = r6 + 1;
        L8:
            CardView r7 = (CardView) ZeusTransformUtils.preCheckCast(r17.readParcelable(CardView.class.getClassLoader()), CardView.class, "com.obric.memorydata.plugin");
            String r8 = r17.readString();
            Intent r11 = (Intent) ZeusTransformUtils.preCheckCast(r17.readParcelable(Intent.class.getClassLoader()), Intent.class, "com.obric.memorydata.plugin");
            FloatingIntentParams r12 = (FloatingIntentParams) ZeusTransformUtils.preCheckCast(r17.readParcelable(FloatingIntentParams.class.getClassLoader()), FloatingIntentParams.class, "com.obric.memorydata.plugin");
            int r3 = r17.readInt();
            if ((r3 & 1) == 0) goto L11;
            boolean r9 = true;
        L13:
            if ((r3 & 2) == 0) goto L15;
            boolean r10 = true;
        L16:
            int r13 = r17.readInt();
            Serializable r14 = r17.readSerializable();
            if (ZeusTransformUtils.instanceOf(r14, ConcurrentHashMap.class) == false) goto L19;
            ConcurrentHashMap<String, String> r15 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        L20:
            if (r5 != 0) goto L22;
        L29:
            r5 = a(r15);
        L30:
            IntentResult<?> r16 = r3;
            IntentResult<?> r18 = new IntentResult(r4, r5, r7, r8, r9, r10, r13, r11, r12, r15);
            int r19 = Math.min(r1, 2);
            ClassLoader r20 = b.class.getClassLoader();
            int r21 = 1;
        L31:
            if (r21 > r19) goto L44;
            if (r21 != 1) goto L38;
            Object r22 = com.obric.b.a.b(r17, r20);
            if (r22 == null) goto L37;
            IntentResult<?> r23 = r16;
            r23.isFinal = ((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L43:
            r21 = r21 + 1;
            r16 = r23;
            goto L31
        L37:
            r23 = r16;
            goto L43
        L38:
            r23 = r16;
            if (r21 != 2) goto L43;
            Object r24 = com.obric.b.a.b(r17, r20);
            if (r24 == null) goto L43;
            r23.remoteCard = (RemoteCard) ZeusTransformUtils.preCheckCast(r24, RemoteCard.class, "com.obric.memorydata.plugin");
            goto L43
        L44:
            IntentResult<?> r25 = r16;
        L45:
            if (r21 > r1) goto L47;
            com.obric.b.a.a(r17, r20);
            r21 = r21 + 1;
            goto L45
        L47:
            return r25;
        L22:
            if ((r5 instanceof Object[]) == false) goto L30;
            if (((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L26;
            boolean r26 = true;
        L27:
            if (r26 == true) goto L29;
        L26:
            r26 = false;
            goto L27
        L19:
            r15 = null;
            goto L20
        L15:
            r10 = false;
            goto L16
        L11:
            r9 = false;
            goto L13
        L7:
            r5 = r17.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        public IntentResult<?>[] a(int r1) {
            return new IntentResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentResult<?> createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentResult<?>[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new b(null);
        sGson$delegate = LazyKt.lazy(a.f7505a);
    }

    public IntentResult() {
        this(0, null, null, null, false, false, 0, null, null, null, 1023, null);
    }

    public IntentResult(int r1, E r2, CardView r3, String r4, boolean r5, boolean r6, int r7, Intent r8, FloatingIntentParams r9, ConcurrentHashMap<String, String> r10) {
        this.ret = r1;
        this.view = r3;
        this.details = r4;
        this.inquireFurther = r5;
        this.needToSummarize = r6;
        this.uiType = r7;
        this.intent = r8;
        this.floatingIntentParams = r9;
        this.ext = r10;
        this.isFinal = true;
        setEntity(r2);
    }

    public /* synthetic */ IntentResult(int r4, Object r5, CardView r6, String r7, boolean r8, boolean r9, int r10, Intent r11, FloatingIntentParams r12, ConcurrentHashMap r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r4 = 1;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r9 = false;
    L21:
        if ((r14 & 64) == 0) goto L24;
        r10 = 1;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r11 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r12 = null;
    L30:
        if ((r14 & 512) == 0) goto L32;
        r13 = null;
    L32:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static final /* synthetic */ Lazy access$getSGson$delegate$cp() {
        return sGson$delegate;
    }

    @Deprecated(message = "use [RemoteCard] instead")
    public static /* synthetic */ void getView$annotations() {
    }

    private final boolean isParcelableArray() {
        return this.entity instanceof Object[];
    }

    public static /* synthetic */ void putEntityFallback$default(IntentResult r1, Object r2, String r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.putEntityFallback(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDetails() {
        return this.details;
    }

    public final E getEntity() {
        return this.entity;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final FloatingIntentParams getFloatingIntentParams() {
        return this.floatingIntentParams;
    }

    public final boolean getInquireFurther() {
        return this.inquireFurther;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final boolean getNeedToSummarize() {
        return this.needToSummarize;
    }

    public final RemoteCard getRemoteCard() {
        return this.remoteCard;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final CardView getView() {
        return this.view;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    public final void putEntityFallback(Object r7) {
        putEntityFallback$default(this, r7, null, null, 6, null);
    }

    public final void putEntityFallback(Object r7, String r8) {
        putEntityFallback$default(this, r7, r8, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putEntityFallback(Object r10, String r11, Boolean r12) {
        if (r10 != null) goto L5;
        Object r1 = null;
    L6:
        setEntity(r1);
        if (r10 != null) goto L15;
        this.entityWrittenToFallbackOnly = false;
        ConcurrentHashMap<String, String> r13 = this.ext;
        if (r13 == null) goto L11;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.remove(KEY_ENTITY_FALLBACK_JSON), String.class, "com.obric.memorydata.plugin");
    L11:
        ConcurrentHashMap<String, String> r9 = this.ext;
        if (r9 == null) goto L62;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r9.remove(KEY_ENTITY_FALLBACK_TYPE), String.class, "com.obric.memorydata.plugin");
        return;
    L62:
        return;
    L15:
        if (r12 == null) goto L17;
        boolean r16 = r12.booleanValue();
    L19:
        if (r11 != null) goto L47;
        if (r16 == true) goto L22;
    L45:
        Class<?> r17 = r10.getClass();
    L46:
        r11 = r17.getName();
        goto L47
    L22:
        if ((r10 instanceof Object[]) == false) goto L24;
        Object[] r18 = (Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.memorydata.plugin");
    L25:
        if (r18 == null) goto L40;
        int r3 = r18.length;
        int r6 = 0;
    L27:
        if (r6 >= r3) goto L35;
        Object r7 = r18[r6];
        if (r7 == null) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == true) goto L36;
        r6 = r6 + 1;
    L36:
        if (r7 == null) goto L40;
        r17 = r7.getClass();
        if (r17 == null) goto L40;
    L31:
        r8 = false;
        goto L32
    L35:
        r7 = null;
    L40:
        Class<?> r19 = r10.getClass().getComponentType();
        if (r19 == null) goto L43;
        r11 = r19.getName();
    L44:
        if (r11 != null) goto L47;
    L43:
        r11 = null;
        goto L44
    L24:
        r18 = null;
    L47:
        if (r16 == false) goto L58;
        r11 = r11 + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L58:
        String r110 = b.a(CREATOR).toJson(r10);     // Catch: Throwable -> L55
        ConcurrentHashMap<String, String> r111 = this.ext;
        if (r111 != null) goto L53;
        r111 = new ConcurrentHashMap();
        this.ext = r111;
    L53:
        Intrinsics.checkNotNullExpressionValue(r110, "json");
        r111.put(KEY_ENTITY_FALLBACK_JSON, r110);
        Intrinsics.checkNotNullExpressionValue(r11, "typeTag");
        r111.put(KEY_ENTITY_FALLBACK_TYPE, r11);
        this.entityWrittenToFallbackOnly = true;
        return;
    L55:
        th = move-exception;
        Log.e(TAG, "putEntityFallback toJson failed: " + th.getMessage());
        return;
    L17:
        r16 = r10 instanceof Object[];
        goto L19
    L5:
        r1 = r10;
        goto L6
    }

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setEntity(E r2) {
        if (r2 != null) goto L4;
    L10:
        this.entity = r2;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, Serializable.class) == true) goto L10;
        throw new RuntimeException("entity must be Parcelable or Serializable");
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public final void setFinal(boolean r1) {
        this.isFinal = r1;
    }

    public final void setFloatingIntentParams(FloatingIntentParams r1) {
        this.floatingIntentParams = r1;
    }

    public final void setInquireFurther(boolean r1) {
        this.inquireFurther = r1;
    }

    public final void setIntent(Intent r1) {
        this.intent = r1;
    }

    public final void setNeedToSummarize(boolean r1) {
        this.needToSummarize = r1;
    }

    public final void setRemoteCard(RemoteCard r1) {
        this.remoteCard = r1;
    }

    public final void setRet(int r1) {
        this.ret = r1;
    }

    public final void setUiType(int r1) {
        this.uiType = r1;
    }

    public final void setView(CardView r1) {
        this.view = r1;
    }

    public String toString() {
        return "IntentResult(ret=" + this.ret + ", view=" + this.view + ", details=" + this.details + ", uiType=" + this.uiType + ", ext=" + this.ext + ", inquireFurther=" + this.inquireFurther + ", needToSummarize=" + this.needToSummarize + ", entity=" + this.entity + ", intent=" + this.intent + ", floatingIntentParams=" + this.floatingIntentParams + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(2);
        Intrinsics.checkNotNullParameter(r6, "parcel");
        r6.writeInt(this.ret);
        Parcelable r1 = null;
        Parcelable[] r2 = null;
        if (this.entityWrittenToFallbackOnly == false) goto L5;
        E r0 = null;
    L6:
        int r4 = 0;
        if ((r0 instanceof Object[]) == true) goto L9;
        r6.writeInt(0);
        if (ZeusTransformUtils.instanceOf(r0, Parcelable.class) == false) goto L23;
        r1 = (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.memorydata.plugin");
    L23:
        r6.writeParcelable(r1, r7);
    L24:
        r6.writeParcelable(this.view, r7);
        r6.writeString(this.details);
        r6.writeParcelable(this.intent, r7);
        r6.writeParcelable(this.floatingIntentParams, r7);
        boolean r8 = this.inquireFurther;
        int r9 = r8;
        if (this.needToSummarize == false) goto L27;
        r9 = (r8 ? 1 : 0) | 2;
    L27:
        r6.writeInt(r9);
        r6.writeInt(this.uiType);
        r6.writeSerializable(this.ext);
        r6.writeValue(Boolean.valueOf(this.isFinal));
        r6.writeValue(this.remoteCard);
        return;
    L9:
        if ((r0 instanceof Parcelable[]) == false) goto L11;
        r2 = (Parcelable[]) ZeusTransformUtils.preCheckCast(r0, Parcelable[].class, "com.obric.memorydata.plugin");
    L11:
        r6.writeInt(1);
        if (r2 == null) goto L14;
        int r3 = r2.length;
    L15:
        r6.writeInt(r3);
        if (r2 == null) goto L24;
        int r5 = r2.length;
    L18:
        if (r4 >= r5) goto L24;
        r6.writeParcelable(r2[r4], r7);
        r4 = r4 + 1;
        goto L18
    L14:
        r3 = 0;
        goto L15
    L5:
        r0 = this.entity;
        goto L6
    }
}
