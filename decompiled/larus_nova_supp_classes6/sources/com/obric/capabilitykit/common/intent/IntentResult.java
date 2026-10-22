package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import el9.a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001SB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010G\u001a\u00020\u0004H\u0016J/\u0010H\u001a\u00020I2\b\u0010\u0005\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\tH\u0016J\u0018\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006T"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult;", "E", "Landroid/os/Parcelable;", "ret", "", "entity", "view", "Lcom/obric/capabilitykit/common/CardView;", "details", "", "inquireFurther", "", "needToSummarize", "uiType", "intent", "Landroid/content/Intent;", "floatingIntentParams", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(ILjava/lang/Object;Lcom/obric/capabilitykit/common/CardView;Ljava/lang/String;ZZILandroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "value", "getEntity", "()Ljava/lang/Object;", "setEntity", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "entityWrittenToFallbackOnly", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFloatingIntentParams", "()Lcom/obric/capabilitykit/common/FloatingIntentParams;", "setFloatingIntentParams", "(Lcom/obric/capabilitykit/common/FloatingIntentParams;)V", "getInquireFurther", "()Z", "setInquireFurther", "(Z)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isFinal", "setFinal", "isParcelableArray", "getNeedToSummarize", "setNeedToSummarize", "remoteCard", "Lcom/obric/capabilitykit/common/RemoteCard;", "getRemoteCard", "()Lcom/obric/capabilitykit/common/RemoteCard;", "setRemoteCard", "(Lcom/obric/capabilitykit/common/RemoteCard;)V", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "getView$annotations", "()V", "getView", "()Lcom/obric/capabilitykit/common/CardView;", "setView", "(Lcom/obric/capabilitykit/common/CardView;)V", "describeContents", "putEntityFallback", "", "", "elementClassName", "array", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
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

    public static final class b implements Parcelable.Creator<IntentResult<?>> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IntentResult<?> createFromParcel(Parcel r1) {
            return b(r1);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.os.Parcelable] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v10, types: [android.os.Parcelable[]] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
        public static IntentResult b(Parcel r18) {
            int r2 = r18.readInt();
            Intrinsics.checkNotNullParameter(r18, "parcel");
            int r4 = r18.readInt();
            if (r18.readInt() != 1) goto L7;
            int r0 = r18.readInt();
            ?? r5 = new Parcelable[r0];
            int r6 = 0;
        L5:
            if (r6 >= r0) goto L8;
            r5[r6] = r18.readParcelable(IntentResult.class.getClassLoader());
            r6 = r6 + 1;
        L8:
            CardView r7 = (CardView) r18.readParcelable(CardView.class.getClassLoader());
            String r8 = r18.readString();
            Intent r11 = (Intent) r18.readParcelable(Intent.class.getClassLoader());
            FloatingIntentParams r12 = (FloatingIntentParams) r18.readParcelable(FloatingIntentParams.class.getClassLoader());
            int r1 = r18.readInt();
            if ((r1 & 1) == 0) goto L11;
            boolean r9 = true;
        L13:
            if ((r1 & 2) == 0) goto L15;
            boolean r10 = true;
        L16:
            int r13 = r18.readInt();
            Serializable r3 = r18.readSerializable();
            Object r14 = null;
            if ((r3 instanceof ConcurrentHashMap) == false) goto L19;
            ConcurrentHashMap r15 = (ConcurrentHashMap) r3;
        L20:
            if (r5 == 0) goto L30;
            if ((r5 instanceof Object[]) == true) goto L24;
        L66:
            IntentResult r16 = new IntentResult(r4, r5, r7, r8, r9, r10, r13, r11, r12, r15);
            int r17 = Math.min(r2, 2);
            ClassLoader r19 = b.class.getClassLoader();
            int r20 = 1;
        L67:
            if (r20 > r17) goto L79;
            if (r20 != 1) goto L73;
            Object r21 = joa.a.c(r18, r19);
            if (r21 == null) goto L77;
            r16.isFinal = ((Boolean) r21).booleanValue();
        L77:
            r20 = r20 + 1;
            goto L67
        L73:
            if (r20 != 2) goto L77;
            Object r22 = joa.a.c(r18, r19);
            if (r22 == null) goto L77;
            r16.remoteCard = (RemoteCard) r22;
        L79:
            if (r20 > r2) goto L81;
            joa.a.d(r18, r19);
            r20 = r20 + 1;
            goto L79
        L81:
            return r16;
        L24:
            if (((Object[]) r5).length != 0) goto L26;
            boolean r23 = true;
        L27:
            if (r23 == true) goto L30;
        L26:
            r23 = false;
        L30:
            if (r15 == null) goto L65;
            String r24 = (String) r15.get(IntentResult.KEY_ENTITY_FALLBACK_JSON);
            if (r24 == null) goto L65;
            if (r24.length() <= 0) goto L37;
            boolean r110 = true;
        L38:
            if (r110 == true) goto L41;
            r24 = null;
        L41:
            if (r24 == null) goto L65;
            String r25 = (String) r15.get(IntentResult.KEY_ENTITY_FALLBACK_TYPE);
            if (r25 == null) goto L65;
            if (r25.length() <= 0) goto L48;
            boolean r111 = true;
        L49:
            if (r111 == true) goto L52;
            r25 = null;
        L52:
            if (r25 == null) goto L65;
            boolean r112 = StringsKt.endsWith$default(r25, "[]", false, 2, null);     // Catch: Throwable -> L63
            if (r112 == false) goto L58;
            r25 = StringsKt.removeSuffix(r25, "[]");     // Catch: Throwable -> L63
        L58:
            Class r26 = a(r25);     // Catch: Throwable -> L63
            if (r112 == false) goto L61;
            Object r27 = ((Gson) IntentResult.access$getSGson$delegate$cp().getValue()).fromJson(r24, Array.newInstance(r26, 0).getClass());     // Catch: Throwable -> L63
        L62:
            r14 = r27;
            goto L65
        L61:
            r27 = ((Gson) IntentResult.access$getSGson$delegate$cp().getValue()).fromJson(r24, r26);     // Catch: Throwable -> L63
        L63:
            th = move-exception;
            th.getMessage();
            goto L65
        L48:
            r111 = false;
            goto L49
        L37:
            r110 = false;
        L65:
            r5 = r14;
            goto L66
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
            r5 = r18.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final IntentResult<?>[] newArray(int r1) {
            return new IntentResult[r1];
        }
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

    public /* synthetic */ IntentResult(int r12, Object r13, CardView r14, String r15, boolean r16, boolean r17, int r18, Intent r19, FloatingIntentParams r20, ConcurrentHashMap r21, int r22, DefaultConstructorMarker r23) {
        int r2 = 1;
        if ((r22 & 1) == 0) goto L5;
        int r1 = 1;
    L6:
        ConcurrentHashMap r4 = null;
        if ((r22 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        CardView r5 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r6 = null;
    L18:
        boolean r8 = false;
        if ((r22 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r22 & 32) != 0) goto L27;
        r8 = r17;
    L27:
        if ((r22 & 64) != 0) goto L31;
        r2 = r18;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Intent r9 = null;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        FloatingIntentParams r10 = null;
    L39:
        if ((r22 & ISmModel.VERSION_0200) != 0) goto L42;
        r4 = r21;
    L42:
        this(r1, r3, r5, r6, r7, r8, r2, r9, r10, r4);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L18
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
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

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setEntity(E r2) {
        if (r2 != null) goto L4;
    L10:
        this.entity = r2;
        return;
    L4:
        if ((r2 instanceof Parcelable) == true) goto L10;
        if ((r2 instanceof Serializable) == true) goto L10;
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
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(2);
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeInt(this.ret);
        Parcelable r1 = null;
        Parcelable[] r2 = null;
        if (this.entityWrittenToFallbackOnly == false) goto L5;
        E r0 = null;
    L6:
        int r3 = 0;
        if ((r0 instanceof Object[]) == true) goto L9;
        r5.writeInt(0);
        if ((r0 instanceof Parcelable) == false) goto L23;
        r1 = (Parcelable) r0;
    L23:
        r5.writeParcelable(r1, r6);
    L24:
        r5.writeParcelable(this.view, r6);
        r5.writeString(this.details);
        r5.writeParcelable(this.intent, r6);
        r5.writeParcelable(this.floatingIntentParams, r6);
        boolean r7 = this.inquireFurther;
        int r8 = r7;
        if (this.needToSummarize == false) goto L27;
        r8 = (r7 ? 1 : 0) | 2;
    L27:
        r5.writeInt(r8);
        r5.writeInt(this.uiType);
        r5.writeSerializable(this.ext);
        r5.writeValue(Boolean.valueOf(this.isFinal));
        r5.writeValue(this.remoteCard);
        return;
    L9:
        if ((r0 instanceof Parcelable[]) == false) goto L11;
        r2 = (Parcelable[]) r0;
    L11:
        r5.writeInt(1);
        if (r2 == null) goto L14;
        int r4 = r2.length;
    L15:
        r5.writeInt(r4);
        if (r2 == null) goto L24;
        int r9 = r2.length;
    L18:
        if (r3 >= r9) goto L24;
        r5.writeParcelable(r2[r3], r6);
        r3 = r3 + 1;
        goto L18
    L14:
        r4 = 0;
        goto L15
    L5:
        r0 = this.entity;
        goto L6
    }

    static {
        CREATOR = new b();
        sGson$delegate = LazyKt.lazy(a.a);
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
        String r14 = r13.remove(KEY_ENTITY_FALLBACK_JSON);
    L11:
        ConcurrentHashMap<String, String> r15 = this.ext;
        if (r15 == null) goto L60;
        String r16 = r15.remove(KEY_ENTITY_FALLBACK_TYPE);
        return;
    L60:
        return;
    L15:
        if (r12 == null) goto L17;
        boolean r17 = r12.booleanValue();
    L19:
        if (r11 != null) goto L45;
        if (r17 == true) goto L22;
    L43:
        Class<?> r18 = r10.getClass();
    L44:
        r11 = r18.getName();
        goto L45
    L22:
        if ((r10 instanceof Object[]) == false) goto L24;
        Object[] r19 = (Object[]) r10;
    L25:
        if (r19 == null) goto L38;
        int r5 = r19.length;
        int r6 = 0;
    L27:
        if (r6 >= r5) goto L35;
        Object r7 = r19[r6];
        if (r7 == null) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == true) goto L36;
        r6 = r6 + 1;
    L36:
        if (r7 == null) goto L38;
        r18 = r7.getClass();
        goto L44
    L31:
        r8 = false;
        goto L32
    L35:
        r7 = null;
    L38:
        Class<?> r110 = r10.getClass().getComponentType();
        if (r110 == null) goto L41;
        r11 = r110.getName();
    L42:
        if (r11 != null) goto L45;
    L41:
        r11 = null;
        goto L42
    L24:
        r19 = null;
    L45:
        if (r17 == false) goto L56;
        r11 = r11.concat("[]");
    L56:
        CREATOR.getClass();     // Catch: Throwable -> L53
        String r111 = ((Gson) access$getSGson$delegate$cp().getValue()).toJson(r10);     // Catch: Throwable -> L53
        ConcurrentHashMap<String, String> r112 = this.ext;
        if (r112 != null) goto L51;
        r112 = new ConcurrentHashMap();
        this.ext = r112;
    L51:
        r112.put(KEY_ENTITY_FALLBACK_JSON, r111);
        r112.put(KEY_ENTITY_FALLBACK_TYPE, r11);
        this.entityWrittenToFallbackOnly = true;
        return;
    L53:
        th = move-exception;
        th.getMessage();
        return;
    L17:
        r17 = r10 instanceof Object[];
        goto L19
    L5:
        r1 = r10;
        goto L6
    }
}
