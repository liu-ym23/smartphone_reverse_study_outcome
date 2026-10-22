package com.larus.common.venue.impl.venue.component;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common.venue.api.AssistantStage;
import com.larus.common.venue.impl.venue.FlowCommonVenueDataCache;
import com.larus.platform.api.e4;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.venue.impl.venue.component.FlowCommonVenueLynxComponent$initLynx$1", f = "FlowCommonVenueLynxComponent.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
final class FlowCommonVenueLynxComponent$initLynx$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $bizScene;
    final /* synthetic */ int $inputBoxShowSetting;
    int label;
    final /* synthetic */ FlowCommonVenueLynxComponent this$0;

    public FlowCommonVenueLynxComponent$initLynx$1(Integer r1, FlowCommonVenueLynxComponent r2, int r3, Continuation<? super FlowCommonVenueLynxComponent$initLynx$1> r4) {
        this.$bizScene = r1;
        this.this$0 = r2;
        this.$inputBoxShowSetting = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowCommonVenueLynxComponent$initLynx$1(this.$bizScene, this.this$0, this.$inputBoxShowSetting, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (((Boolean) r10).booleanValue() == false) goto L103;
        FLogger r11 = FLogger.a;
        r11.i("FlowCommonVenueComponent", "[initLynx] refresh pocketPageData success");
        Lazy r3 = FlowCommonVenueDataCache.a;
        Map<String, ? extends Object> r4 = FlowCommonVenueDataCache.b(this.$bizScene);
        if (r4 != null) goto L16;
    L19:
        if (r2 == false) goto L21;
        r11.i("FlowCommonVenueComponent", "[initLynx] refresh pocketPageData generate fail, use FE default pocketPageData");
    L22:
        FlowCommonVenueLynxComponent r5 = this.this$0;
        AssistantStage r6 = AssistantStage.Enter;
        int r7 = FlowCommonVenueLynxComponent.K;
        String r8 = r5.B3(r4, r6);
        r11.i("FlowCommonVenueComponent", "[initLynx] refresh pocketPageData flow success, update pageDataJson generate = " + r8 + ", isShowInputBox = " + this.$inputBoxShowSetting);
        e4 r12 = this.this$0.v;
        if (r12 == null) goto L25;
        r12.updateData(r8);
    L25:
        Map<String, ? extends Object> r13 = this.this$0.F;
        Drawable r9 = null;
        PorterDuffColorFilter r14 = null;
        r9 = null;
        r9 = null;
        if (r13 == null) goto L28;
        Object r15 = r13.get("pocket_page_data");
    L30:
        if ((r15 instanceof Map) == false) goto L32;
        Map r16 = (Map) r15;
    L33:
        if (r16 == null) goto L38;
        Object r17 = r16.get("input_placeholder");
        if ((r17 instanceof String) == false) goto L38;
        String r18 = (String) r17;
    L39:
        if (r18 == null) goto L43;
        ICoreInputAbility r20 = this.this$0.E3();
        if (r20 == null) goto L43;
        r20.M5(r18);
    L43:
        FlowCommonVenueLynxComponent r110 = this.this$0;
        Map<String, ? extends Object> r21 = r110.F;
        if (r21 == null) goto L46;
        Object r22 = r21.get("pocket_page_data");
    L48:
        if ((r22 instanceof Map) == false) goto L50;
        Map r23 = (Map) r22;
    L51:
        if (r23 == null) goto L56;
        Object r24 = r23.get("input_tintcolor");
        if ((r24 instanceof String) == false) goto L56;
        String r25 = (String) r24;
    L57:
        if (r25 == null) goto L107;
        String r26 = x09.b.a(r25);
        if (r26 == null) goto L107;
        int r27 = ColorProtector.parseColor(r26);
        va8.o r28 = r110.D3();
        if (r28 == null) goto L63;
        va8.b r30 = r28.rX();
    L64:
        if (r30 == null) goto L66;
        View r31 = r30.b;
    L68:
        if ((r31 instanceof EditText) == false) goto L70;
        EditText r32 = (EditText) r31;
    L71:
        if (r30 == null) goto L73;
        View r33 = r30.c;
    L75:
        if ((r33 instanceof ImageView) == false) goto L77;
        ImageView r34 = (ImageView) r33;
    L79:
        if (Build.VERSION.SDK_INT < 29) goto L91;
        if (r32 == null) goto L91;
        Integer r35 = Integer.valueOf(r27);
        Drawable r36 = ContextCompat.getDrawable(r110.getContext(), v19.c.b(2130970994, r110.getContext(), 2131240253));
        if (r36 == null) goto L89;
        Drawable r37 = r36.mutate();
        if (r37 == null) goto L89;
        if (r35 == null) goto L87;
        PorterDuffColorFilter r38 = new PorterDuffColorFilter(r35.intValue(), PorterDuff.Mode.SRC_IN);
    L88:
        r37.setColorFilter(r38);
    L90:
        r32.setTextCursorDrawable(r37);
        goto L91
    L87:
        r38 = null;
    L89:
        r37 = null;
    L91:
        if (r34 == null) goto L107;
        Integer r40 = Integer.valueOf(r27);
        int r41 = r110.getContext().getResources().getIdentifier("larus_ic_send_common_venue", "drawable", r110.getContext().getPackageName());
        if (r41 == 0) goto L102;
        Drawable r111 = ContextCompat.getDrawable(r110.getContext(), r41);
        if (r111 == null) goto L102;
        Drawable r112 = r111.mutate();
        if (r112 == null) goto L102;
        if (r40 == null) goto L101;
        r14 = new PorterDuffColorFilter(r40.intValue(), PorterDuff.Mode.SRC_IN);
    L101:
        r112.setColorFilter(r14);
        r9 = r112;
    L102:
        r34.setImageDrawable(r9);
        goto L107
    L77:
        r34 = null;
        goto L79
    L73:
        r33 = null;
        goto L75
    L70:
        r32 = null;
        goto L71
    L66:
        r31 = null;
        goto L68
    L63:
        r30 = null;
    L107:
        return Unit.INSTANCE;
    L56:
        r25 = null;
        goto L57
    L50:
        r23 = null;
        goto L51
    L46:
        r22 = null;
    L38:
        r18 = null;
        goto L39
    L32:
        r16 = null;
        goto L33
    L28:
        r15 = null;
        goto L30
    L21:
        this.this$0.F = r4;
        r11.i("FlowCommonVenueComponent", "[initLynx] refresh pocketPageData generate success, refreshPocketResponseDict.size = " + r4.size());
        goto L22
    L16:
        if (r4.isEmpty() == true) goto L19;
        r2 = false;
        goto L19
    L103:
        FLogger.a.e("FlowCommonVenueComponent", "[initLynx] refresh pocketPageData fail, use FE default pocketPageData");
        FlowCommonVenueLynxComponent r113 = this.this$0;
        Map<String, ? extends Object> r42 = MapsKt.emptyMap();
        AssistantStage r43 = AssistantStage.Enter;
        int r44 = FlowCommonVenueLynxComponent.K;
        String r114 = r113.B3(r42, r43);
        e4 r45 = this.this$0.v;
        if (r45 == null) goto L107;
        r45.updateData(r114);
        goto L107
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FLogger.a.e("FlowCommonVenueComponent", "[initLynx] start to refresh pocketPageData");
        Lazy r115 = FlowCommonVenueDataCache.a;
        Integer r116 = this.$bizScene;
        this.label = 1;
        r10 = FlowCommonVenueDataCache.d(1, "chat_action_bar", r116, this);
        if (r10 != r0) goto L12;
        return r0;
    }
}
