package com.larus.chat.job.impl.page.edit;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedance.router.SmartRouter;
import com.larus.chat.job.impl.databinding.LarusChatJobEditFragmentBinding;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1", f = "ChatJobEditFragment.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
final class ChatJobEditFragment$observeEditList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatJobEditFragment this$0;

    /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1", f = "ChatJobEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatJobEditFragment this$0;

        /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$1", f = "ChatJobEditFragment.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChatJobEditFragment this$0;

            /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ ChatJobEditFragment a;

                public a(ChatJobEditFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r1, Continuation r2) {
                    List r3 = (List) r1;
                    ChatJobEditAdapter r4 = this.a.e;
                    if (r4 == null) goto L6;
                    r4.submitList(r3);
                L6:
                    return Unit.INSTANCE;
                }
            }

            public C00981(ChatJobEditFragment r1, Continuation<? super C00981> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00981(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                ChatJobEditFragment r6 = this.this$0;
                int r2 = ChatJobEditFragment.n;
                kotlinx.coroutines.flow.i1<List<z>> r7 = r6.aa0().getListItems();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$2", f = "ChatJobEditFragment.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChatJobEditFragment this$0;

            /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$2$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ ChatJobEditFragment a;

                public a(ChatJobEditFragment r1) {
                    this.a = r1;
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
                public final Object emit(Object r23, Continuation r24) {
                    f0 r1 = (f0) r23;
                    ChatJobEditFragment r2 = this.a;
                    LarusChatJobEditFragmentBinding r3 = r2.d;
                    float r4 = 0.6f;
                    boolean r7 = true;
                    int r8 = 0;
                    if (r3 == null) goto L30;
                    FrameLayout r9 = r3.g;
                    if (r2.ca0() == false) goto L8;
                L10:
                    boolean r10 = false;
                L11:
                    AppCompatImageView r11 = r3.h;
                    if ((!r10) == false) goto L14;
                    int r12 = 0;
                L15:
                    r11.setVisibility(r12);
                    AppCompatImageView r5 = r3.c;
                    if (r10 == false) goto L18;
                    int r13 = 0;
                L19:
                    r5.setVisibility(r13);
                    if (r10 == false) goto L29;
                    PopupWindow r6 = r2.f;
                    if (r6 == null) goto L24;
                    ChatJobEditFragment.T90(r6);
                L24:
                    r9.setContentDescription(gz8.f.b("button_save"));
                    r9.setEnabled(r1.b());
                    if (r1.b() == false) goto L27;
                    float r14 = 1.0f;
                L28:
                    r9.setAlpha(r14);
                    goto L30
                L27:
                    r14 = 0.6f;
                    goto L28
                L29:
                    r9.setContentDescription(r2.getString(2131900765));
                    r9.setEnabled(true);
                    r9.setAlpha(1.0f);
                    goto L30
                L18:
                    r13 = 8;
                    goto L19
                L14:
                    r12 = 8;
                    goto L15
                L8:
                    if (r1.o == false) goto L10;
                    r10 = true;
                L30:
                    final ChatJobEditFragment r15 = this.a;
                    d0 r16 = r1.q;
                    LarusChatJobEditFragmentBinding r17 = r15.d;
                    if (r17 == null) goto L158;
                    if (r16 == null) goto L36;
                    r17.o.animate().cancel();
                    r17.o.setTranslationY(0.0f);
                    r17.o.setVisibility(0);
                    r17.q.setText(gz8.f.b("scheduledTasks_newTask_setting_frequency"));
                    LarusChatJobEditFragmentBinding r18 = r15.d;
                    if (r18 == null) goto L84;
                    boolean r19 = r16 instanceof d0.a;
                    if (r19 == true) goto L53;
                L55:
                    boolean r110 = false;
                L57:
                    if ((r16 instanceof d0.b) == true) goto L59;
                    if (r19 == false) goto L164;
                    d0.a r111 = (d0.a) r16;
                    if (StringsKt.trim(r111.a).toString().length() <= 0) goto L65;
                    boolean r112 = true;
                L66:
                    if (r112 == true) goto L68;
                L70:
                    boolean r113 = false;
                L71:
                    r18.l.setEnabled(r113);
                    FrameLayout r114 = r18.l;
                    if (r113 == true) goto L74;
                    if (r110 == true) goto L74;
                L75:
                    r114.setAlpha(r4);
                    AppCompatImageView r20 = r18.m;
                    if ((!r110) == false) goto L78;
                    int r115 = 0;
                L79:
                    r20.setVisibility(r115);
                    ProgressBar r21 = r18.n;
                    if (r110 == false) goto L82;
                    int r116 = 0;
                L83:
                    r21.setVisibility(r116);
                    goto L84
                L82:
                    r116 = 8;
                    goto L83
                L78:
                    r115 = 8;
                L74:
                    r4 = 1.0f;
                    goto L75
                L68:
                    if (r111.b == true) goto L70;
                L69:
                    r113 = true;
                    goto L71
                L65:
                    r112 = false;
                    goto L66
                L164:
                    throw new NoWhenBranchMatchedException();
                L59:
                    if (((d0.b) r16).a.isEmpty() == true) goto L70;
                L53:
                    if (((d0.a) r16).b == false) goto L55;
                    r110 = true;
                L84:
                    boolean r22 = r16 instanceof d0.b;
                    if (r22 == false) goto L88;
                    String r117 = "weekly";
                L90:
                    String r118 = "chat_job_weekly_card";
                    if (Intrinsics.areEqual(r15.i, r117) == true) goto L119;
                    r17.j.removeAllViews();
                    if (r22 == false) goto L105;
                    LarusChatJobEditFragmentBinding r119 = r15.d;
                    if (r119 != null) goto L97;
                    boolean r25 = r22;
                    String r120 = r117;
                    String r26 = "chat_job_weekly_card";
                L104:
                    String r121 = r120;
                    String r27 = null;
                    r8 = 0;
                L116:
                    r15.i = r121;
                L120:
                    if (r25 == false) goto L139;
                    d0.b r28 = (d0.b) r16;
                    LarusChatJobEditFragmentBinding r0 = r15.d;
                    if (r0 == null) goto L158;
                    LinearLayout r29 = r0.j;
                    if (r29 == null) goto L158;
                    LinearLayout r30 = (LinearLayout) r29.findViewWithTag(r26);
                    if (r30 == null) goto L158;
                    ChatJobEditWeekday[] r31 = ChatJobEditWeekday.values();
                    int r32 = r31.length;
                    int r33 = 0;
                L129:
                    if (r33 >= r32) goto L158;
                    ChatJobEditWeekday r34 = r31[r33];
                    View r35 = r30.findViewWithTag("chat_job_weekly_check_" + r34.name());
                    if (r35 == null) goto L137;
                    if (r28.a.contains(r34) == false) goto L135;
                    int r36 = 0;
                L136:
                    r35.setVisibility(r36);
                    goto L137
                L135:
                    r36 = 8;
                L137:
                    r33 = r33 + 1;
                    goto L129
                L139:
                    if ((r16 instanceof d0.a) == false) goto L160;
                    d0.a r37 = (d0.a) r16;
                    LarusChatJobEditFragmentBinding r38 = r15.d;
                    if (r38 == null) goto L158;
                    LinearLayout r39 = r38.j;
                    if (r39 == null) goto L158;
                    EditText r40 = (EditText) r39.findViewWithTag("chat_job_custom_frequency_input");
                    if (r40 == null) goto L158;
                    r40.setEnabled(!r37.b);
                    Editable r41 = r40.getText();
                    if (r41 == null) goto L150;
                    String r42 = r41.toString();
                L152:
                    if (Intrinsics.areEqual(r42, r37.a) == true) goto L158;
                    r40.setText(r37.a);
                    Editable r43 = r40.getText();
                    if (r43 == null) goto L156;
                    r8 = r43.length();
                L156:
                    r40.setSelection(r8);
                    goto L158
                L150:
                    r42 = r27;
                    goto L152
                L160:
                    throw new NoWhenBranchMatchedException();
                L97:
                    Context r44 = r119.a.getContext();
                    LinearLayout r45 = new LinearLayout(r44);
                    r45.setTag("chat_job_weekly_card");
                    r45.setOrientation(1);
                    int r122 = gz8.g.a;
                    Intrinsics.checkNotNull(r44);
                    r45.setBackground(gz8.g.a(r44));
                    LinearLayout.LayoutParams r46 = new LinearLayout.LayoutParams(-1, -2);
                    r46.topMargin = i5.q();
                    r45.setLayoutParams(r46);
                    ChatJobEditWeekday[] r47 = ChatJobEditWeekday.values();
                    int r48 = r47.length;
                    int r49 = 0;
                    int r123 = 0;
                L98:
                    if (r123 >= r48) goto L103;
                    final ChatJobEditWeekday r50 = r47[r123];
                    int r124 = r49 + 1;
                    LinearLayout r51 = new LinearLayout(r44);
                    ChatJobEditWeekday[] r125 = r47;
                    int r126 = r48;
                    r51.setTag("chat_job_weekly_row_" + r50.name());
                    r51.setOrientation(0);
                    r51.setGravity(16);
                    r51.setClickable(true);
                    r51.setFocusable(true);
                    r51.setMinimumHeight(i5.h0());
                    String r210 = r118;
                    r51.setPadding(i5.q(), 0, i5.q(), 0);
                    r51.setLayoutParams(new LinearLayout.LayoutParams(-1, i5.h0()));
                    r51.setOnClickListener(new q(r15, r50));
                    TextView r52 = new TextView(r44);
                    r52.setText(r50.getLabel());
                    r52.setIncludeFontPadding(false);
                    r52.setTextColor(gz8.g.b(r44));
                    r52.setTextSize(0, i5.t());
                    boolean r211 = r22;
                    String r127 = r117;
                    r52.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                    r51.addView(r52);
                    AppCompatImageView r53 = new AppCompatImageView(r44);
                    r53.setTag("chat_job_weekly_check_" + r50.name());
                    r53.setImageResource(2131240022);
                    r53.setColorFilter(gz8.g.b(r44));
                    r53.setLayoutParams(new LinearLayout.LayoutParams(i5.A(), i5.A()));
                    r51.addView(r53);
                    r45.addView(r51);
                    if (r49 == ArraysKt.getLastIndex(ChatJobEditWeekday.values())) goto L102;
                    View r54 = new View(r44);
                    r54.setBackgroundColor(gz8.g.d(r44));
                    LinearLayout.LayoutParams r55 = new LinearLayout.LayoutParams(-1, i5.b());
                    r55.setMarginStart(i5.q());
                    r55.setMarginEnd(i5.q());
                    r54.setLayoutParams(r55);
                    r45.addView(r54);
                L102:
                    r123 = r123 + 1;
                    r117 = r127;
                    r49 = r124;
                    r47 = r125;
                    r48 = r126;
                    r118 = r210;
                    r22 = r211;
                    goto L98
                L103:
                    r25 = r22;
                    r120 = r117;
                    r26 = r118;
                    r119.j.addView(r45);
                    goto L104
                L105:
                    r25 = r22;
                    String r128 = r117;
                    r26 = "chat_job_weekly_card";
                    if ((r16 instanceof d0.a) == false) goto L118;
                    d0.a r56 = (d0.a) r16;
                    LarusChatJobEditFragmentBinding r57 = r15.d;
                    if (r57 != null) goto L110;
                    r27 = null;
                    r8 = 0;
                L115:
                    r121 = r128;
                    goto L116
                L110:
                    final Context r58 = r57.a.getContext();
                    FrameLayout r59 = new FrameLayout(r58);
                    int r60 = gz8.g.a;
                    Intrinsics.checkNotNull(r58);
                    r59.setBackground(gz8.g.a(r58));
                    r59.setMinimumHeight(((Number) i5.E0.getValue()).intValue());
                    r59.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
                    LinearLayout.LayoutParams r61 = new LinearLayout.LayoutParams(-1, -2);
                    r61.topMargin = i5.q();
                    r59.setLayoutParams(r61);
                    final EditText r62 = new EditText(r58);
                    r62.setTag("chat_job_custom_frequency_input");
                    r27 = null;
                    r62.setBackground(null);
                    r62.setGravity(8388659);
                    r62.setHint(gz8.f.b("scheduledTasks_newTask_repeats_custom_placeholder"));
                    r8 = 0;
                    r62.setIncludeFontPadding(false);
                    r62.setInputType(131073);
                    r62.setMinLines(4);
                    r62.setMaxLines(6);
                    r62.setPadding(0, 0, 0, 0);
                    r62.setTextColor(gz8.g.b(r58));
                    r62.setHintTextColor(gz8.g.c(r58));
                    r62.setTextSize(0, i5.t());
                    r62.setText(r56.a);
                    Editable r63 = r62.getText();
                    if (r63 == null) goto L113;
                    int r64 = r63.length();
                L114:
                    r62.setSelection(r64);
                    r62.addTextChangedListener(new y(r15));
                    r62.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    r59.addView(r62);
                    r57.j.addView(r59);
                    r62.requestFocus();
                    r62.post(new j(r58, r62));
                    goto L115
                L113:
                    r64 = 0;
                    goto L114
                L118:
                    throw new NoWhenBranchMatchedException();
                L119:
                    r25 = r22;
                    r27 = null;
                    r26 = "chat_job_weekly_card";
                    goto L120
                L88:
                    if ((r16 instanceof d0.a) == false) goto L162;
                    r117 = "custom";
                    goto L90
                L162:
                    throw new NoWhenBranchMatchedException();
                L36:
                    if (r17.o.getVisibility() != 0) goto L38;
                    boolean r65 = true;
                L39:
                    if (r65 == false) goto L41;
                L44:
                    r17.o.animate().cancel();
                    r17.o.setVisibility(8);
                    r17.o.setTranslationY(0.0f);
                    if (r7 == false) goto L158;
                    r15.i = null;
                    r17.j.removeAllViews();
                    r15.ba0(r17.a);
                    goto L158
                L41:
                    if (r15.i != null) goto L44;
                    r7 = false;
                    goto L44
                L38:
                    r65 = false;
                L158:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass2(ChatJobEditFragment r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                ChatJobEditFragment r6 = this.this$0;
                int r2 = ChatJobEditFragment.n;
                kotlinx.coroutines.flow.i1<f0> r7 = r6.aa0().getUiState();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$3", f = "ChatJobEditFragment.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChatJobEditFragment this$0;

            /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$observeEditList$1$1$3$a */
            public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
                public final /* synthetic */ ChatJobEditFragment a;

                public a(ChatJobEditFragment r1) {
                    this.a = r1;
                }

                public final boolean equals(Object r3) {
                    if ((r3 instanceof FlowCollector) == true) goto L5;
                    return false;
                L5:
                    if ((r3 instanceof FunctionAdapter) == true) goto L7;
                    return false;
                L7:
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
                }

                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.a, ChatJobEditFragment.class, "handleEffect", "handleEffect(Lcom/larus/chat/job/impl/page/edit/ChatJobEditEffect;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                public final Object emit(Object r2, Continuation r3) {
                    ChatJobEditFragment r0 = this.a;
                    Object r4 = AnonymousClass3.access$invokeSuspend$handleEffect(r0, (i) r2, r3);
                    if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r4;
                L6:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass3(ChatJobEditFragment r1, Continuation<? super AnonymousClass3> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass3(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                ChatJobEditFragment r6 = this.this$0;
                int r2 = ChatJobEditFragment.n;
                Flow<i> r7 = r6.aa0().getEffects();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }

            public static final Object access$invokeSuspend$handleEffect(ChatJobEditFragment r6, i r7, Continuation r8) {
                int r9 = ChatJobEditFragment.n;
                r6.getClass();
                if (Intrinsics.areEqual(r7, i.a.a) == false) goto L6;
                r6.X90();
            L40:
                return Unit.INSTANCE;
            L6:
                if (Intrinsics.areEqual(r7, i.b.a) == false) goto L42;
                Bundle r10 = r6.getArguments();
                boolean r11 = false;
                if (r10 != null) goto L10;
            L12:
                boolean r12 = false;
            L13:
                String r1 = r6.aa0().currentConversationId();
                String r2 = null;
                if (r1 != null) goto L16;
            L18:
                r1 = null;
            L19:
                Context r3 = r6.getContext();
                com.larus.bmhome.a0 r4 = com.larus.bmhome.b0.a(r6);
                r6.X90();
                if (r12 == false) goto L40;
                if (r1 != null) goto L23;
            L24:
                r11 = true;
            L26:
                if (r11 == false) goto L31;
                FLogger r13 = FLogger.a;
                StringBuilder r0 = new StringBuilder("openConversation skipped: conversationId is null or blank, jobId=");
                Bundle r14 = r6.getArguments();
                if (r14 == null) goto L30;
                r2 = r14.getString("chat_job_id");
            L30:
                r0.append(r2);
                r13.e("ChatJobEditFragment", r0.toString());
                goto L40
            L31:
                if (r3 != null) goto L36;
                FLogger r15 = FLogger.a;
                StringBuilder r5 = new StringBuilder("openConversation skipped: context is null, jobId=");
                Bundle r16 = r6.getArguments();
                if (r16 == null) goto L35;
                r2 = r16.getString("chat_job_id");
            L35:
                r5.append(r2);
                r15.e("ChatJobEditFragment", r5.toString());
                goto L40
            L36:
                if (r4 == null) goto L38;
                r4.J90(1, null, r1, "chat_conversation");
            L38:
                com.bytedance.router.i r17 = SmartRouter.buildRoute(r3, "//flow/chat_page");
                Bundle r18 = new Bundle();
                r18.putString("argConversationId", r1);
                r18.putBoolean("is_create_sub_conversation", true);
                r18.putInt("argBotConversationType", 3);
                r18.putString("enter_method", "cron_job");
                r18.putString("enter_from", "chat_job");
                r18.putString("argPreviousPage", "chat_job");
                r17.c.putExtras(r18);
                r17.d();
                goto L40
            L23:
                if (StringsKt.isBlank(r1) == false) goto L26;
            L16:
                if ((!StringsKt.isBlank(r1)) == false) goto L18;
            L10:
                if (r10.getBoolean("chat_job_edit_open_conversation_after_run") != true) goto L12;
                r12 = true;
                goto L13
            L42:
                throw new NoWhenBranchMatchedException();
            }
        }

        public AnonymousClass1(ChatJobEditFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new C00981(this.this$0, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass3(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatJobEditFragment$observeEditList$1(ChatJobEditFragment r1, Continuation<? super ChatJobEditFragment$observeEditList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatJobEditFragment$observeEditList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
