package com.bytedance.android.live.room.share.jsbridge;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UseReturnDataCallbackHandler extends LiveWebShareCallback {
    public static final /* synthetic */ int c = 0;
    public SelectType a;
    public final com.bytedance.android.live.room.share.jsbridge.a b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/share/jsbridge/UseReturnDataCallbackHandler$SelectType;", "", "NONE", "IM_RELATION", "IM_USER_ING", "DIRECT", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SelectType extends Enum<SelectType> {
        public static final SelectType DIRECT = null;
        public static final SelectType IM_RELATION = null;
        public static final SelectType IM_USER_ING = null;
        public static final SelectType NONE = null;
        public static final /* synthetic */ SelectType[] a = null;

        static {
            SelectType r1 = new SelectType("NONE", 0);
            NONE = r1;
            SelectType r2 = new SelectType("IM_RELATION", 1);
            IM_RELATION = r2;
            SelectType r3 = new SelectType("IM_USER_ING", 2);
            IM_USER_ING = r3;
            SelectType r4 = new SelectType("DIRECT", 3);
            DIRECT = r4;
            a = new SelectType[]{r1, r2, r3, r4};
        }

        public static SelectType valueOf(String r1) {
            return (SelectType) r27.a.a(SelectType.class, r1);
        }

        public static SelectType[] values() {
            return (SelectType[]) a.clone();
        }

        public SelectType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ UseReturnDataCallbackHandler a;

        public b(UseReturnDataCallbackHandler r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.a != SelectType.NONE) goto L9;
            ALogger.d("UseReturnDataCallbackHandler", "actionFinishWithFailure user cancel dialog ");     // Catch: Throwable -> L6
            this.a.a(null);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    public final void onPreShare() {
        this.a = SelectType.IM_USER_ING;
    }

    public final void onDialogDismiss() {
        super.onDialogDismiss();
        ALogger.d("UseReturnDataCallbackHandler", " onDialogDismiss curSelectType:" + this.a);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(Boolean.valueOf(new Handler(Looper.getMainLooper()).postDelayed(new b(this), 200)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public UseReturnDataCallbackHandler(com.bytedance.android.live.room.share.jsbridge.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.b = r2;
        this.a = SelectType.NONE;
    }

    public final void a(Throwable r4) {
        JSONObject r0 = new JSONObject();
        r0.put(Constants.OperatorKey.CODE, 0);
        r0.put("button", "cancel");
        if (r4 == null) goto L5;
        r0.put(Constants.OperatorKey.MSG, r4.getMessage());
    L5:
        this.b.a(r0);
    }

    public final void onChannelShare(String r9) {
        Intrinsics.checkNotNullParameter(r9, "channel");
        ALogger.d("UseReturnDataCallbackHandler", " onChannelShare channel:" + r9);
        if (Intrinsics.areEqual(r9, "chat_merge") == false) goto L6;
        this.a = SelectType.IM_RELATION;
        return;
    L6:
        if (CollectionsKt.listOf(new String[]{"weixin", "weixin_moments", "qzone", "qq", "more", "weibo", "qr_code", "generate_image"}).contains(r9) == false) goto L10;
        this.a = SelectType.DIRECT;
        return;
    }

    public final void onContactSelect(boolean r1) {
        super.onContactSelect(r1);
        if (r1 == true) goto L6;
        this.a = SelectType.NONE;
        return;
    }

    public final void onFail(Throwable r5) {
        super/*com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback*/.onFail(r5);
        StringBuilder r0 = new StringBuilder(" onFail message: ");
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.getMessage();
    L6:
        r0.append(r2);
        ALogger.d("UseReturnDataCallbackHandler", r0.toString());
        StringBuilder r3 = new StringBuilder("actionFinishWithFailure  ");
        if (r5 == null) goto L9;
        r1 = r5.getMessage();
    L9:
        r3.append(r1);
        ALogger.d("UseReturnDataCallbackHandler", r3.toString());
        a(r5);
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(String r8, Map r9) {
        JSONObject r0 = new JSONObject();
        boolean r2 = true;
        r0.put(Constants.OperatorKey.CODE, 1);
        r0.put("button", r8);
        List r10 = null;
        if (r9 == null) goto L5;
        List r3 = (List) r9.get("to_user_ids");
    L6:
        JSONArray r4 = new JSONArray();
        if (r3 == null) goto L12;
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.put((String) r5.next());
    L12:
        JSONObject r6 = new JSONObject();
        r6.put("uid", r4);
        Unit r7 = Unit.INSTANCE;
        r0.put("extra_info", r6);
        if (r9 == null) goto L19;
        List r12 = (List) r9.get("im_checked");
        if (r12 == null) goto L19;
        String r13 = (String) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L19;
        r0.put("im_checked", Intrinsics.areEqual(r13, "true"));
    L19:
        if (r9 == null) goto L25;
        List r14 = (List) r9.get("token_alert_checked");
        if (r14 == null) goto L25;
        String r15 = (String) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L25;
        r0.put("token_alert_checked", Intrinsics.areEqual(r15, "true"));
    L25:
        com.bytedance.android.live.room.share.jsbridge.a r16 = this.b;
        if (r9 == null) goto L28;
        List r17 = (List) r9.get(Constants.OperatorKey.CODE);
    L29:
        List r18 = r17;
        if (r18 != null) goto L32;
    L35:
        boolean r19 = true;
    L36:
        if (r19 == true) goto L39;
        r0.put(Constants.OperatorKey.CODE, CastIntegerProtector.parseInt((String) ListProtector.get(r17, 0)));
    L39:
        if (r9 == null) goto L41;
        r10 = (List) r9.get("qrcode_alert_platform");
    L41:
        List r20 = r10;
        if (r20 != null) goto L44;
    L47:
        if (r2 == true) goto L49;
        r0.put("qrcode_alert_platform", ListProtector.get(r10, 0));
    L49:
        r16.a(r0);
        return;
    L44:
        if (r20.isEmpty() == true) goto L47;
        r2 = false;
        goto L47
    L32:
        if (r18.isEmpty() == true) goto L35;
        r19 = false;
        goto L36
    L28:
        r17 = null;
        goto L29
    L5:
        r3 = null;
        goto L6
    }

    public final void onSuccess(String r3, String r4) {
        super/*com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback*/.onSuccess(r3, r4);
        ALogger.d("UseReturnDataCallbackHandler", " onSuccess platform:" + r3 + " shareType:" + r4);
        if ((!Intrinsics.areEqual(r3, "chat_merge")) == false) goto L6;
        b(r3, null);
        return;
    }

    public final void onSuccessWithExtra(String r1, String r2, Map<String, ? extends List<String>> r3) {
        super/*com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback*/.onSuccessWithExtra(r1, r2, r3);
        b(r1, r3);
    }
}
