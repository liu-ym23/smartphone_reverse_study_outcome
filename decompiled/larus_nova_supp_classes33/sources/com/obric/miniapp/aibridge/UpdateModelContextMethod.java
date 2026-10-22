package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u0004/012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J@\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0018JZ\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J:\u0010'\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010)\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010%H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\u00122\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010%H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u001a2\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002¨\u00063"}, d2 = {"Lcom/obric/miniapp/aibridge/UpdateModelContextMethod;", "Lcom/obric/miniapp/aibridge/AbsUpdateModelContextMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsUpdateModelContextMethodIDL$UpdateModelContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsUpdateModelContextMethodIDL$UpdateModelContextResultModel;", "uploadContextEvent", "Lcom/obric/miniapp/aibridge/UpdateModelContextMethod$UploadContextEventResult;", "bizTaskId", "", "appKey", "msgId", "convId", "sessionId", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPayloadJson", "Lorg/json/JSONObject;", "eventId", "action", "Lcom/obric/miniapp/aibridge/UpdateModelContextMethod$ActionType;", "appletId", "pageType", "pageId", "messageId", "conversationId", "entityMeta", "contentBlocks", "", "priorityOf", "buildEventId", "bizTaskAnchor", "resolveBizTaskAnchor", "extractIdentityFromBlocks", "optNonBlankString", "key", "md5Hex", "input", "UploadContextEventResult", "ActionType", "ModelContextStorage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateModelContextMethod extends AbsUpdateModelContextMethodIDL {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/miniapp/aibridge/UpdateModelContextMethod$ActionType;", "", "jsValue", "", "eventType", "", "needDedup", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;IZ)V", "getJsValue", "()Ljava/lang/String;", "getEventType", "()I", "getNeedDedup", "()Z", "UI_STATE", "BIZ_STATE", "USER_ACTION", "SYSTEM", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType BIZ_STATE = null;
        public static final a Companion = null;
        public static final ActionType SYSTEM = null;
        public static final ActionType UI_STATE = null;
        public static final ActionType USER_ACTION = null;
        public static final /* synthetic */ ActionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int eventType;
        private final String jsValue;
        private final boolean needDedup;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ActionType> getEntries() {
            return b;
        }

        static {
            ActionType r6 = new ActionType("UI_STATE", 0, "ui_state", 0, true);
            UI_STATE = r6;
            ActionType r0 = new ActionType("BIZ_STATE", 1, "biz_state", 1, true);
            BIZ_STATE = r0;
            ActionType r1 = new ActionType("USER_ACTION", 2, "user_action", 2, false);
            USER_ACTION = r1;
            ActionType r2 = new ActionType("SYSTEM", 3, "system", 3, true);
            SYSTEM = r2;
            ActionType[] r3 = {r6, r0, r1, r2};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public final int getEventType() {
            return this.eventType;
        }

        public final String getJsValue() {
            return this.jsValue;
        }

        public final boolean getNeedDedup() {
            return this.needDedup;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2, String r3, int r4, boolean r5) {
            super(r1, r2);
            this.jsValue = r3;
            this.eventType = r4;
            this.needDedup = r5;
        }
    }

    public static final class a {
    }

    public static final class b {
        public static final Lazy a = null;

        static {
            a = LazyKt.lazy(new f0());
        }
    }

    public static final class c {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "UploadContextEventResult(code=" + this.a + ", msg=" + this.b + ')';
        }

        public c(long r1, String r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.UI_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ActionType.BIZ_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ActionType.SYSTEM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ActionType.USER_ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.aibridge.UpdateModelContextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.aibridge.UpdateModelContextMethod$handle$1", f = "UpdateModelContextMethod.kt", i = {0, 0}, l = {168}, m = "invokeSuspend", n = {"eventId", "shouldUpload"}, s = {"L$0", "I$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsUpdateModelContextMethodIDL.b> $callback;
        final /* synthetic */ AbsUpdateModelContextMethodIDL.a $params;
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ UpdateModelContextMethod this$0;

        /* JADX INFO: renamed from: com.obric.miniapp.aibridge.UpdateModelContextMethod$handle$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ContainerType.values().length];
                r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ContainerType.WORKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public AnonymousClass1(e3.d r1, f3.h<AbsUpdateModelContextMethodIDL.b> r2, UpdateModelContextMethod r3, AbsUpdateModelContextMethodIDL.a r4, Continuation<? super AnonymousClass1> r5) {
            this.$bridgeContext = r1;
            this.$callback = r2;
            this.this$0 = r3;
            this.$params = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$bridgeContext, this.$callback, this.this$0, this.$params, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r26) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r7 = "";
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            int r3 = this.I$0;
            String r9 = (String) this.L$0;
            ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L8
            Object r1 = r26;
        L353:
            Object r4 = Result.constructor-impl((c) r1);     // Catch: Throwable -> L8
        L358:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L362;
            FLogger.a.e("UpdateModelContextMethod", "updateModelContext upload failed, eventId=" + r9, r5);
            r4 = null;
        L362:
            c r6 = (c) r4;
        L364:
            if (r3 == 0) goto L370;
            if (r6 != null) goto L367;
        L369:
            boolean r8 = false;
        L371:
            if (r3 == 0) goto L386;
            if (r8 == true) goto L386;
            JSONObject r10 = new JSONObject();
            if (r6 == null) goto L377;
            long r11 = r6.a;
        L378:
            r10.put("code", r11);
            if (r6 == null) goto L381;
            String r12 = r6.b;
        L382:
            if (r12 == null) goto L385;
            r7 = r12;
        L385:
            r10.put("msg", r7);
            JSONObject r13 = r10;
        L387:
            f3.h<AbsUpdateModelContextMethodIDL.b> r14 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsUpdateModelContextMethodIDL.b.class, "<this>");
            AbsUpdateModelContextMethodIDL.b r15 = k3.c.a(AbsUpdateModelContextMethodIDL.b.class);
            AbsUpdateModelContextMethodIDL.b r16 = r15;
            r16.setOk(r8);
            r16.setErrors(r13);
            f3.h.a.b(r14, r15);
            return Unit.INSTANCE;
        L381:
            r12 = null;
            goto L382
        L377:
            r11 = -1;
        L386:
            r13 = null;
            goto L387
        L367:
            if (r6.a != 0) goto L369;
        L370:
            r8 = true;
        L8:
            th = th;
        L357:
            Result.Companion r17 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L358
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r26);
            ActionType r18 = ActionType.BIZ_STATE;
            d3.a0 r19 = this.$bridgeContext.getContainerContext();
            if (r19 == null) goto L16;
            ContainerType r110 = r19.getContainerType();
            if (r110 == null) goto L16;
        L17:
            Ref.ObjectRef r111 = new Ref.ObjectRef();
            Ref.ObjectRef r112 = new Ref.ObjectRef();
            Ref.ObjectRef r113 = new Ref.ObjectRef();
            Ref.ObjectRef r114 = new Ref.ObjectRef();
            int[] r115 = a.a;
            int r20 = r115[r110.ordinal()];
            if (r20 == 1) goto L27;
            if (r20 == 2) goto L26;
            if (r20 == 3) goto L25;
            String r21 = "floating";
            if (Intrinsics.areEqual(r110.getTypeName().toLowerCase(Locale.ROOT), "floating") == true) goto L28;
            r21 = "unknown";
        L28:
            int r22 = r115[r110.ordinal()];
            if (r22 == 1) goto L50;
            if (r22 == 2) goto L40;
            if (r22 != 3) goto L81;
            AppletRuntime r23 = (AppletRuntime) this.$bridgeContext.d(AppletRuntime.class);
            if (r23 == null) goto L36;
            r111.element = r23.h.K;
        L36:
            if (r19 == null) goto L38;
            String r24 = r19.getContainerId();
        L39:
            r114.element = r24;
            goto L81
        L38:
            r24 = null;
        L81:
            CharSequence r25 = (CharSequence) r111.element;
            if (r25 != null) goto L84;
        L87:
            boolean r27 = true;
        L88:
            if (r27 == false) goto L93;
            if (r19 == null) goto L91;
            String r28 = r19.getAppletId();
        L92:
            r111.element = r28;
            goto L93
        L91:
            r28 = null;
        L93:
            CharSequence r29 = (CharSequence) r111.element;
            if (r29 != null) goto L96;
        L99:
            boolean r30 = true;
        L100:
            if (r30 == false) goto L104;
            AppletRuntime r31 = (AppletRuntime) this.$bridgeContext.d(AppletRuntime.class);
            if (r31 == null) goto L104;
            r111.element = r31.h.K;
        L104:
            WidgetContainer r32 = (WidgetContainer) this.$bridgeContext.d(WidgetContainer.class);
            if (r32 == null) goto L163;
            CharSequence r33 = (CharSequence) r111.element;
            if (r33 != null) goto L109;
        L112:
            boolean r34 = true;
        L113:
            if (r34 == false) goto L126;
            String r35 = r32.getAppletId();
            if (r35 != null) goto L125;
            com.bytedance.ai.widget.contianer.m r36 = r32.g;
            if (r36 == null) goto L119;
            r35 = r36.a;
        L120:
            if (r35 != null) goto L125;
            Widget r37 = r32.x();
            if (r37 == null) goto L124;
            r35 = ((AIPackage) r37).b;
            goto L125
        L124:
            r35 = null;
            goto L125
        L119:
            r35 = null;
        L125:
            r111.element = r35;
        L126:
            CharSequence r38 = (CharSequence) r112.element;
            if (r38 != null) goto L129;
        L132:
            boolean r39 = true;
        L133:
            if (r39 == false) goto L141;
            String r40 = r32.b;
            if (r40 != null) goto L140;
            com.bytedance.ai.widget.contianer.m r41 = r32.g;
            if (r41 == null) goto L139;
            r40 = r41.k;
            goto L140
        L139:
            r40 = null;
        L140:
            r112.element = r40;
        L141:
            CharSequence r42 = (CharSequence) r113.element;
            if (r42 != null) goto L144;
        L147:
            boolean r43 = true;
        L148:
            if (r43 == false) goto L150;
            r113.element = r32.l();
        L150:
            CharSequence r44 = (CharSequence) r114.element;
            if (r44 != null) goto L153;
        L156:
            boolean r45 = true;
        L157:
            if (r45 == false) goto L163;
            com.bytedance.ai.widget.contianer.m r46 = r32.g;
            if (r46 == null) goto L161;
            String r47 = r46.b;
        L162:
            r114.element = r47;
            goto L163
        L161:
            r47 = null;
            goto L162
        L153:
            if (StringsKt.isBlank(r44) == true) goto L156;
            r45 = false;
            goto L157
        L144:
            if (StringsKt.isBlank(r42) == true) goto L147;
            r43 = false;
            goto L148
        L129:
            if (StringsKt.isBlank(r38) == true) goto L132;
            r39 = false;
            goto L133
        L109:
            if (StringsKt.isBlank(r33) == true) goto L112;
            r34 = false;
        L163:
            String r48 = (String) r111.element;
            if (r48 == null) goto L166;
            String r49 = StringsKt.trim(r48).toString();
        L167:
            if (r49 != null) goto L169;
            r49 = "";
        L169:
            String r50 = (String) r112.element;
            if (r50 == null) goto L172;
            String r51 = StringsKt.trim(r50).toString();
        L173:
            if (r51 != null) goto L175;
            String r210 = "";
        L176:
            String r52 = (String) r113.element;
            if (r52 == null) goto L179;
            String r53 = StringsKt.trim(r52).toString();
        L180:
            if (r53 != null) goto L182;
            r53 = "";
        L182:
            String r116 = (String) r114.element;
            if (r116 == null) goto L185;
            String r117 = StringsKt.trim(r116).toString();
        L186:
            if (r117 != null) goto L189;
            r117 = "";
        L189:
            if (StringsKt.isBlank(r49) == false) goto L191;
        L389:
            f3.h<AbsUpdateModelContextMethodIDL.b> r54 = this.$callback;
            StringBuilder r55 = new StringBuilder("missing context: containerType=");
            r55.append(r110.getTypeName());
            r55.append(", appletId=");
            r55.append(!StringsKt.isBlank(r49));
            r55.append(", conversationId=");
            r55.append(!StringsKt.isBlank(r210));
            r55.append(", pageId=");
            r55.append(!StringsKt.isBlank(r117));
            r55.append(", messageId=");
            r55.append(!StringsKt.isBlank(r53));
            f3.h.a.a(r54, r55.toString(), null, null, 14);
            return Unit.INSTANCE;
        L191:
            if (StringsKt.isBlank(r210) == true) goto L389;
            if (StringsKt.isBlank(r117) == true) goto L389;
            UpdateModelContextMethod r118 = this.this$0;
            JSONObject r119 = this.$params.getEntityMeta();
            List<JSONObject> r120 = this.$params.getContent();
            int r121 = UpdateModelContextMethod.a;
            r118.getClass();
            String r122 = UpdateModelContextMethod.d(r119, "biz_task_id");
            if (r122 != null) goto L286;
            r122 = UpdateModelContextMethod.d(r119, "bizTaskId");
            if (r122 != null) goto L286;
            String r123 = UpdateModelContextMethod.d(r119, "uniqueId");
            if (r123 != null) goto L285;
            String r124 = UpdateModelContextMethod.d(r119, "unique_id");
            if (r124 == null) goto L204;
            r123 = r124;
            goto L285
        L204:
            if (r120 != null) goto L206;
        L205:
            r0 = r0;
            String r56 = null;
        L279:
            if (r56 != null) goto L287;
            r56 = UpdateModelContextMethod.d(r119, "entity_id");
            if (r56 != null) goto L287;
            r56 = UpdateModelContextMethod.d(r119, "entityId");
        L287:
            this.this$0.getClass();
            int[] r57 = d.a;
            int r58 = r57[r18.ordinal()];
            if (r58 != 1) goto L290;
            String r59 = UpdateModelContextMethod.c(r49 + '|' + r117 + '|' + r53);
        L308:
            if (r56 != null) goto L310;
            r56 = r59;
        L310:
            UpdateModelContextMethod r125 = this.this$0;
            JSONObject r126 = this.$params.getEntityMeta();
            List<JSONObject> r127 = this.$params.getContent();
            r125.getClass();
            int r60 = r57[r18.ordinal()];
            if (r60 != 1) goto L313;
            String r61 = "P0";
        L323:
            if (StringsKt.isBlank(r53) == false) goto L325;
            String r62 = r210;
        L326:
            JSONObject r128 = new JSONObject();
            if (r126 == null) goto L330;
            r128.put("_meta", r126);
        L330:
            if (r127 == null) goto L336;
            JSONArray r129 = new JSONArray();
            Iterator r130 = r127.iterator();
        L333:
            if (r130.hasNext() == false) goto L335;
            r129.put((JSONObject) r130.next());
            r130 = r130;
            goto L333
        L335:
            Unit r131 = Unit.INSTANCE;
            r128.put("content", r129);
        L336:
            JSONObject r132 = new JSONObject();
            r132.put("event_id", r59);
            r132.put("type", r18.getJsValue());
            r132.put("version", "v1");
            AppHost.Companion r133 = AppHost.a;
            String r211 = r53;
            r132.put("timestamp", r133.getAppClock().currentTimeMillis());
            r132.put("app_id", r49);
            r132.put("page_id", r117);
            r132.put("page_type", r21);
            r132.put("session_id", r62);
            r132.put("priority", r61);
            r132.put("source", "applet");
            r132.put("content", r128.toString());
            String r63 = r132.toString();
            this.this$0.getClass();
            String r64 = UpdateModelContextMethod.c(r63);
            if (r18.getNeedDedup() == false) goto L344;
            Lazy r65 = b.a;
            Intrinsics.checkNotNullParameter(r59, "eventId");
            Intrinsics.checkNotNullParameter(r64, "payloadHash");
            Lazy r66 = b.a;
            String r134 = ((Keva) r66.getValue()).getString("hash_" + r59, "");
            long r135 = ((Keva) r66.getValue()).getLong("ts_" + r59, 0);
            long r136 = r133.getAppClock().currentTimeMillis();
            if (Intrinsics.areEqual(r134, r64) == false) goto L344;
            if ((r136 - r135) >= 5000) goto L344;
            r3 = 0;
        L345:
            Lazy r137 = b.a;
            Intrinsics.checkNotNullParameter(r59, "eventId");
            Intrinsics.checkNotNullParameter(r63, "payload");
            Intrinsics.checkNotNullParameter(r64, "payloadHash");
            long r138 = r133.getAppClock().currentTimeMillis();
            Lazy r139 = b.a;
            ((Keva) r139.getValue()).storeString("state_" + r59, r63);
            ((Keva) r139.getValue()).storeString("hash_" + r59, r64);
            ((Keva) r139.getValue()).storeLong("ts_" + r59, r138);
            if (r3 == 0) goto L363;
            UpdateModelContextMethod r67 = this.this$0;
            Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L355
            this.L$0 = r59;     // Catch: Throwable -> L355
            this.I$0 = r3;     // Catch: Throwable -> L355
            this.label = 1;     // Catch: Throwable -> L355
            r1 = UpdateModelContextMethod.b(r67, r56, r49, r211, r210, r210, r63);     // Catch: Throwable -> L355
            Object r69 = r0;
            if (r1 != r69) goto L352;
            return r69;
        L352:
            r9 = r59;
        L355:
            th = th;
            r9 = r59;
            goto L357
        L363:
            r6 = null;
        L344:
            r3 = 1;
            goto L345
        L325:
            r62 = r53;
            goto L326
        L313:
            if (r60 != 2) goto L315;
        L320:
            r61 = "P1";
            goto L323
        L315:
            if (r60 == 3) goto L320;
            if (r60 != 4) goto L319;
            r61 = "P2";
            goto L323
        L319:
            throw new NoWhenBranchMatchedException();
        L290:
            if (r58 != 2) goto L292;
            if (r56 != null) goto L300;
        L303:
            boolean r70 = true;
        L304:
            if (r70 == true) goto L306;
            r59 = UpdateModelContextMethod.c(r18.getJsValue() + '|' + r49 + '|' + r56);
            goto L308
        L306:
            r59 = UpdateModelContextMethod.c(r18.getJsValue() + '|' + r49 + '|' + r21 + '|' + r117 + '|' + r53);
            goto L308
        L300:
            if (StringsKt.isBlank(r56) == true) goto L303;
            r70 = false;
            goto L304
        L292:
            if (r58 == 3) goto L297;
            if (r58 == 4) goto L297;
            throw new NoWhenBranchMatchedException();
        L297:
            r59 = UUID.randomUUID().toString();
            Intrinsics.checkNotNull(r59);
            goto L308
        L206:
            Iterator<JSONObject> r140 = r120.iterator();
        L208:
            if (r140.hasNext() == false) goto L205;
            JSONObject r71 = r140.next();
            Iterator<JSONObject> r141 = r140;
            r0 = r0;
            if (Intrinsics.areEqual(r71.optString("type"), "entity") == false) goto L277;
            JSONArray r72 = r71.optJSONArray("entities");
            if (r72 == null) goto L277;
            int r73 = r72.length();
            int r142 = 0;
        L215:
            if (r142 >= r73) goto L277;
            int r143 = r73;
            JSONObject r74 = r72.optJSONObject(r142);
            JSONArray r212 = r72;
            if (r74 == null) goto L276;
            r56 = r74.optString("resource_id");
            if (r56 != null) goto L222;
        L227:
            r56 = r74.optString("resourceId");
            if (r56 == null) goto L236;
            if ((!StringsKt.isBlank(r56)) == true) goto L233;
            r56 = null;
        L233:
            if (r56 != null) goto L279;
        L236:
            r56 = r74.optString("unique_id");
            if (r56 != null) goto L239;
        L244:
            r56 = r74.optString("uniqueId");
            if (r56 != null) goto L247;
        L252:
            r56 = r74.optString("entity_id");
            if (r56 != null) goto L255;
        L260:
            r56 = r74.optString("entityId");
            if (r56 != null) goto L263;
        L268:
            r56 = r74.optString("orderId");
            if (r56 == null) goto L276;
            if ((!StringsKt.isBlank(r56)) == true) goto L274;
            r56 = null;
        L274:
            if (r56 == null) goto L276;
        L263:
            if ((!StringsKt.isBlank(r56)) == true) goto L266;
            r56 = null;
        L266:
            if (r56 == null) goto L268;
        L255:
            if ((!StringsKt.isBlank(r56)) == true) goto L258;
            r56 = null;
        L258:
            if (r56 == null) goto L260;
        L247:
            if ((!StringsKt.isBlank(r56)) == true) goto L250;
            r56 = null;
        L250:
            if (r56 == null) goto L252;
        L239:
            if ((!StringsKt.isBlank(r56)) == true) goto L242;
            r56 = null;
        L242:
            if (r56 == null) goto L244;
        L222:
            if ((!StringsKt.isBlank(r56)) == true) goto L225;
            r56 = null;
        L225:
            if (r56 == null) goto L227;
        L276:
            r142 = r142 + 1;
            r73 = r143;
            r72 = r212;
        L277:
            r140 = r141;
            r0 = r0;
        L285:
            r56 = r123;
        L286:
            r0 = r0;
            r56 = r122;
            goto L287
        L185:
            r117 = null;
            goto L186
        L179:
            r53 = null;
            goto L180
        L175:
            r210 = r51;
            goto L176
        L172:
            r51 = null;
            goto L173
        L166:
            r49 = null;
            goto L167
        L96:
            if (StringsKt.isBlank(r29) == true) goto L99;
            r30 = false;
            goto L100
        L84:
            if (StringsKt.isBlank(r25) == true) goto L87;
            r27 = false;
            goto L88
        L40:
            k2.j r75 = (k2.j) this.$bridgeContext.d(k2.j.class);
            if (r75 == null) goto L43;
            r111.element = r75.getAppletId();
        L43:
            if (r19 == null) goto L46;
            String r76 = r19.getAppId();
            if (r76 == null) goto L46;
        L49:
            r114.element = r76;
        L46:
            if (r19 == null) goto L48;
            r76 = r19.getContainerId();
            goto L49
        L48:
            r76 = null;
            goto L49
        L50:
            WidgetContainer r77 = (WidgetContainer) this.$bridgeContext.d(WidgetContainer.class);
            if (r77 == null) goto L69;
            String r144 = r77.getAppletId();
            if (r144 != null) goto L58;
            com.bytedance.ai.widget.contianer.m r145 = r77.g;
            if (r145 == null) goto L57;
            r144 = r145.a;
            goto L58
        L57:
            r144 = null;
        L58:
            r111.element = r144;
            String r146 = r77.b;
            if (r146 != null) goto L64;
            com.bytedance.ai.widget.contianer.m r147 = r77.g;
            if (r147 == null) goto L63;
            r146 = r147.k;
            goto L64
        L63:
            r146 = null;
        L64:
            r112.element = r146;
            r113.element = r77.l();
            com.bytedance.ai.widget.contianer.m r78 = r77.g;
            if (r78 == null) goto L67;
            String r79 = r78.b;
        L68:
            r114.element = r79;
            goto L69
        L67:
            r79 = null;
        L69:
            CharSequence r80 = (CharSequence) r114.element;
            if (r80 != null) goto L72;
        L75:
            boolean r81 = true;
        L76:
            if (r81 == false) goto L81;
            if (r19 == null) goto L79;
            String r82 = r19.getAppId();
        L80:
            r114.element = r82;
            goto L81
        L79:
            r82 = null;
            goto L80
        L72:
            if (StringsKt.isBlank(r80) == true) goto L75;
            r81 = false;
            goto L76
        L25:
            r21 = "worker";
            goto L28
        L26:
            r21 = "page";
            goto L28
        L27:
            r21 = "widget";
        L16:
            r110 = ContainerType.NONE;
            goto L17
        }
    }

    static {
    }

    public final boolean mustRunInMain() {
        return false;
    }

    public UpdateModelContextMethod() {
    }

    public static String c(String r10) {
        byte[] r1 = MessageDigest.getInstance("MD5").digest(r10.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r1);
        return ArraysKt.joinToString$default(r1, "", null, null, 0, null, new e0(), 30, null);
    }

    public static String d(JSONObject r0, String r1) {
        if (r0 == null) goto L8;
        String r2 = r0.optString(r1);
        if (r2 == null) goto L8;
        if ((!StringsKt.isBlank(r2)) == false) goto L8;
        return r2;
    L8:
        return null;
    }

    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsUpdateModelContextMethodIDL.a r4 = (AbsUpdateModelContextMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r12, r14, this, r4, null), 3, null);
    }

    public static final c b(UpdateModelContextMethod r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        r13.getClass();
        JSONObject r6 = new JSONObject();
        r6.put("biz_task_id", r14);
        r6.put("app_key", r15);
        Long r1 = StringsKt.toLongOrNull(r16);
        if (r1 == null) goto L5;
        r6.put("msg_id", r1.longValue());
    L5:
        Long r2 = StringsKt.toLongOrNull(r17);
        if (r2 == null) goto L8;
        r6.put("conv_id", r2.longValue());
    L8:
        Long r3 = StringsKt.toLongOrNull(r18);
        if (r3 == null) goto L11;
        r6.put("session_id", r3.longValue());
    L11:
        r6.put("content", r19);
        r6.put("timestamp", AppHost.a.getAppClock().currentTimeMillis());
        Triple r4 = HttpExtKt.c("AISDK", String.class, "/alice/mini_program/upload_context_event", "POST", null, r6, null, false, null, null, null, 7936);
        BizResponse r5 = (BizResponse) r4.component1();
        dm9.a.a r7 = (dm9.a.a) r4.component2();
        Throwable r8 = (Throwable) r4.component3();
        if (r5 != null) goto L24;
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("upload_context_event http failed, bizTaskId=");
        r10.append(r14);
        r10.append(", code=");
        if (r7 == null) goto L17;
        Integer r11 = Boxing.boxInt(r7.a);
    L18:
        r10.append(r11);
        r10.append(", msg=");
        if (r7 == null) goto L21;
        String r12 = r7.b;
    L22:
        r10.append(r12);
        r9.e("UpdateModelContextMethod", r10.toString(), r8);
        return null;
    L21:
        r12 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L24:
        return new c(r5.getCode(), r5.getMsg());
    }
}
