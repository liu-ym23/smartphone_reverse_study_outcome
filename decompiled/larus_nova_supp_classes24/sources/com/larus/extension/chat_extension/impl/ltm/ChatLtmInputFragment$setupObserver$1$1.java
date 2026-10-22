package com.larus.extension.chat_extension.impl.ltm;

import androidx.appcompat.widget.AppCompatTextView;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.extension.chat_extension.impl.databinding.LarusLayoutChatLtmInputBinding;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmInputFragment$setupObserver$1$1", f = "ChatLtmInputFragment.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
final class ChatLtmInputFragment$setupObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusLayoutChatLtmInputBinding $this_run;
    int label;
    final /* synthetic */ ChatLtmInputFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatLtmInputFragment a;
        public final /* synthetic */ LarusLayoutChatLtmInputBinding b;

        /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmInputFragment$setupObserver$1$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0096a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InsertBotRespStatus.values().length];
                r0[InsertBotRespStatus.StartInsert.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[InsertBotRespStatus.OutOfCntLimit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[InsertBotRespStatus.OutOfSizeLimit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[InsertBotRespStatus.ReviewNotPass.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[InsertBotRespStatus.Success.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[InsertBotRespStatus.RepeatedMemory.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public a(ChatLtmInputFragment r1, LarusLayoutChatLtmInputBinding r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            InsertBotRespStatus r7 = (InsertBotRespStatus) r5;
            if (r7 == InsertBotRespStatus.StartInsert) goto L6;
            ChatLtmInputFragment r8 = this.a;
            r8.d.removeCallbacks(r8.j);
            e1.o(this.b.f);
        L6:
            switch(C0096a.a[r7.ordinal()]) {
                case 1: goto L49;
                case 2: goto L46;
                case 3: goto L39;
                case 4: goto L38;
                case 5: goto L9;
                case 6: goto L8;
                default: goto L47;
            };
        L8:
            this.b.c.setVisibility(4);
            ChatLtmInputFragment.S90(this.a, this.b.g);
            t19.s.a.g(AppHost.a.getApplication(), 2131907376, false);
            goto L49
        L9:
            this.b.c.setVisibility(4);
            ChatLtmInputFragment r9 = this.a;
            int r10 = ChatLtmInputFragment.k;
            ChatLtmViewModel r11 = r9.U90();
            String r12 = null;
            if (r11 == null) goto L12;
            String r13 = r11.getBotID();
        L13:
            ChatLtmViewModel r0 = this.a.U90();
            if (r0 == null) goto L16;
            String r1 = r0.getConversationID();
        L17:
            ChatLtmViewModel r2 = this.a.U90();
            if (r2 == null) goto L20;
            String r3 = r2.getCurrentPage();
        L21:
            ChatLtmViewModel r4 = this.a.U90();
            if (r4 == null) goto L24;
            r12 = r4.getPreviousPage();
        L24:
            JSONObject r14 = new JSONObject();
            Intrinsics.checkNotNullParameter(r14, "params");
            if (r13 != null) goto L50;
        L29:
            if (r1 == null) goto L31;
            r14.put("conversation_id", r1);     // Catch: JSONException -> L27
        L31:
            if (r3 == null) goto L33;
            r14.put("current_page", r3);     // Catch: JSONException -> L27
        L33:
            if (r12 == null) goto L37;
            r14.put("previous_page", r12);     // Catch: JSONException -> L27
        L27:
            e = move-exception;
            FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickSaveMemory " + e.getLocalizedMessage());
        L37:
            TrackParams r15 = new TrackParams().merge(r14);
            by7.a r16 = new by7.a("click_save_memory");
            r16.a.merge(r15);
            r16.b();
            this.a.T90();
            goto L49
        L50:
            r14.put("bot_id", r13);     // Catch: JSONException -> L27
            goto L29
        L20:
            r3 = null;
            goto L21
        L16:
            r1 = null;
            goto L17
        L12:
            r13 = null;
            goto L13
        L38:
            ChatLtmInputFragment.S90(this.a, this.b.g);
            this.b.c.setVisibility(0);
            this.b.d.setText(this.a.getString(2131905567));
            goto L49
        L39:
            ChatLtmInputFragment.S90(this.a, this.b.g);
            ChatLtmViewModel r17 = this.a.U90();
            if (r17 == null) goto L49;
            BotMemoryConfig r19 = r17.getConfig();
            if (r19 == null) goto L49;
            Integer r20 = r19.getBotMemorySizeLimit();
            if (r20 == null) goto L49;
            LarusLayoutChatLtmInputBinding r21 = this.b;
            ChatLtmInputFragment r22 = this.a;
            int r23 = r20.intValue();
            r21.c.setVisibility(0);
            AppCompatTextView r24 = r21.d;
            StringCompanionObject r25 = StringCompanionObject.INSTANCE;
            r24.setText(String.format(r22.getString(2131907361), Arrays.copyOf(new Object[]{Boxing.boxInt(r23)}, 1)));
            goto L49
        L46:
            this.b.c.setVisibility(4);
            ChatLtmInputFragment r26 = this.a;
            int r27 = ChatLtmInputFragment.k;
            r26.T90();
            t19.s.a.g(AppHost.a.getApplication(), 2131907366, false);
            goto L49
        L47:
            t19.s.a.g(AppHost.a.getApplication(), 2131908214, false);
            ChatLtmInputFragment.S90(this.a, this.b.g);
        L49:
            return Unit.INSTANCE;
        }
    }

    public ChatLtmInputFragment$setupObserver$1$1(ChatLtmInputFragment r1, LarusLayoutChatLtmInputBinding r2, Continuation<? super ChatLtmInputFragment$setupObserver$1$1> r3) {
        this.this$0 = r1;
        this.$this_run = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatLtmInputFragment$setupObserver$1$1(this.this$0, this.$this_run, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ChatLtmInputFragment r7 = this.this$0;
        int r2 = ChatLtmInputFragment.k;
        ChatLtmViewModel r8 = r7.U90();
        if (r8 == null) goto L18;
        d1<InsertBotRespStatus> r9 = r8.getInsertStatus();
        if (r9 == null) goto L18;
        a r3 = new a(this.this$0, this.$this_run);
        this.label = 1;
        if (r9.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
