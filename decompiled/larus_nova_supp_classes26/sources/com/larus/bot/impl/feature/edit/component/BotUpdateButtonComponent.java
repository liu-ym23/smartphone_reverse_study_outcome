package com.larus.bot.impl.feature.edit.component;

import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import com.larus.bot.impl.feature.edit.feature.accesspermission.BotPublicPermissionBSDialog;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotUpdateButtonComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bot/impl/feature/ability/IBotUpdateButtonAbility;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botUpdateAbility", "Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "getBotUpdateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "botUpdateAbility$delegate", "onAttach", "", "onParentViewCreated", "setupUpdate", "()Lkotlin/Unit;", "setupFinishBtn", "refreshCreateBtn", "canCreate", "", "(Z)Lkotlin/Unit;", "tryToUpdate", "handleUpdateSuccess", "newBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "mobClickComplete", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateButtonComponent extends ComponentFeature implements ru8.g {
    public final Lazy h;
    public final Lazy i;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final ru8.e F2() {
        return (ru8.e) this.h.getValue();
    }

    public final ru8.f L2() {
        return (ru8.f) this.i.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ru8.g.class);
    }

    public BotUpdateButtonComponent() {
        this.h = LazyKt.lazy(new r0(this));
        this.i = LazyKt.lazy(new s0(this));
    }

    public final void B2() {
        ru8.e r0 = F2();
        if (r0 != null) goto L5;
    L18:
        ru8.e r1 = F2();
        if (r1 == null) goto L33;
        LarusPageBotEditBinding r2 = r1.e();
        if (r2 == null) goto L34;
        ru8.f r3 = L2();
        if (r3 == null) goto L31;
        final BotUpdateViewModel r4 = r3.c50();
        if (r4 == null) goto L31;
        if (r4.getCanAddBgImage() == false) goto L30;
        com.larus.utils.e1.x(r2.h);
        com.larus.utils.e1.x(r2.j);
        r2.i.setText(r2.a.getContext().getString(2131905454));
        N2(false);
        com.larus.utils.e1.d(r2.i, new t0(r4, this));
        ConstraintLayout r5 = r2.I;
        int r6 = c7.b(88);
        r5.setPaddingRelative(r5.getPaddingStart(), r5.getPaddingTop(), r5.getPaddingEnd(), r6);
        goto L31
    L30:
        com.larus.utils.e1.o(r2.h);
    L31:
        Unit r7 = Unit.INSTANCE;
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if (r0.e() == null) goto L18;
        ru8.f r8 = L2();
        if (r8 == null) goto L17;
        final BotUpdateViewModel r9 = r8.c50();
        if (r9 == null) goto L17;
        ru8.e r10 = F2();
        if (r10 == null) goto L17;
        LifecycleOwner r11 = r10.s4();
        if (r11 == null) goto L17;
        Transformations.distinctUntilChanged(r9.getReady()).observe(r11, new a(new u0(this)));
        r9.getUpdate().observe(r11, new a(new v0(this, r9)));
    L17:
        Unit r12 = Unit.INSTANCE;
        goto L18
    }

    @Override // ru8.g
    public final void CK() {
        ru8.f r0 = L2();
        if (r0 == null) goto L58;
        BotUpdateViewModel r1 = r0.c50();
        if (r1 == null) goto L60;
        Integer r2 = r1.getPrivateStatus();
        if (r2 != null) goto L11;
    L32:
        ru8.f r3 = L2();
        if (r3 == null) goto L35;
        BotModel r4 = r3.FH();
    L36:
        String r5 = r1.checkUserEditArea(r4).toString();
        ru8.f r6 = L2();
        if (r6 == null) goto L41;
        com.larus.bmhome.setting.b r7 = r6.U9();
        if (r7 == null) goto L41;
        r7.f(r5);
    L41:
        ru8.e r8 = F2();
        if (r8 == null) goto L50;
        com.larus.common_ui.dialog.l0 r9 = r8.uL();
        if (r9 == null) goto L50;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r9);
        goto L50
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L49:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    L50:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BotUpdateButtonComponent$tryToUpdate$1(r1, null), 3, null);
        return;
    L35:
        r4 = null;
        goto L36
    L11:
        if (r2.intValue() != 1) goto L32;
        if (Intrinsics.areEqual(r1.getPrivateStatus(), r1.getOriginPrivateStatus()) == true) goto L32;
        ru8.f r10 = L2();
        boolean r11 = false;
        if (r10 != null) goto L17;
    L19:
        boolean r12 = false;
    L20:
        if (r12 == false) goto L32;
        BotPublicPermissionBSDialog r13 = new BotPublicPermissionBSDialog();
        Pair[] r14 = new Pair[2];
        r14[0] = TuplesKt.to("public_permission_scene_argument", 1);
        Integer r15 = r1.getPrivateStatus();
        if (r15 != null) goto L25;
    L27:
        r14[1] = TuplesKt.to("public_status_key", Boolean.valueOf(r11));
        r13.setArguments(com.larus.utils.f.c(r14));
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r16 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "BotPublicPermissionBSDialog", r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r13, r17) == true) goto L61;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L52
    L31:
        r13.show(r16, "BotPublicPermissionBSDialog");
        return;
    L61:
        return;
    L25:
        if (r15.intValue() != 1) goto L27;
        r11 = true;
        goto L27
    L17:
        if (r10.an() != true) goto L19;
        r12 = true;
        goto L20
    L60:
        return;
    }

    @Override // ru8.g
    public final void ix() {
        ru8.f r0 = L2();
        if (r0 == null) goto L185;
        BotUpdateViewModel r1 = r0.c50();
        if (r1 == null) goto L186;
        String r2 = r1.getDraftId();
        ru8.f r3 = L2();
        if (r3 == null) goto L11;
        String r4 = r3.Y8();
        if (r4 == null) goto L11;
    L12:
        BotEditParam r5 = r1.getEditParam();
        String r6 = "uploaded";
        String r7 = "default";
        int r8 = 0;
        String r9 = null;
        if (r5 != null) goto L15;
    L35:
        BotEditParam r10 = r1.getEditParam();
        boolean r11 = true;
        String r12 = "no_image";
        if (r10 == null) goto L58;
        BgImage r13 = r10.getBgImage();
        if (r13 == null) goto L40;
        String r14 = r13.bgImgUri;
    L41:
        if (r14 != null) goto L43;
    L46:
        boolean r15 = true;
    L47:
        if (r15 == false) goto L49;
        r6 = "no_image";
    L57:
        r12 = r6;
        goto L58
    L49:
        BgImage r16 = r10.getBgImage();
        if (r16 == null) goto L54;
        BgImageInfo r17 = r16.bgImageInfo;
        if (r17 == null) goto L54;
        boolean r18 = Intrinsics.areEqual(r17.getAiGenBgImg(), Boolean.TRUE);
    L55:
        if (r18 == false) goto L57;
        r6 = "ai_generate";
    L54:
        r18 = false;
        goto L55
    L43:
        if (StringsKt.isBlank(r14) == true) goto L46;
        r15 = false;
        goto L47
    L40:
        r14 = null;
    L58:
        BotEditParam r19 = r1.getEditParam();
        if (r19 == null) goto L65;
        BgImage r20 = r19.getBgImage();
        if (r20 == null) goto L65;
        Boolean r21 = r20.getBgImgOpen();
        if (r21 == null) goto L65;
        boolean r22 = r21.booleanValue();
    L66:
        BotModel r23 = r1.getBotInfo();
        if (r23 == null) goto L69;
        String r24 = r23.getBotId();
    L70:
        BotEditParam r25 = r1.getEditParam();
        if (r25 == null) goto L75;
        SpeakerVoice r26 = r25.getVoice();
        if (r26 == null) goto L75;
        String r27 = r26.getId();
    L76:
        BotEditParam r110 = r1.getEditParam();
        if (r110 == null) goto L79;
        SpeakerVoice r111 = r110.getVoice();
    L80:
        String r112 = dv8.c.b(r111);
        BotEditParam r113 = r1.getEditParam();
        if (r113 == null) goto L83;
        String r114 = r113.getPrologue();
    L84:
        boolean r115 = com.larus.utils.o0.d(r114);
        BotEditParam r116 = r1.getEditParam();
        if (r116 == null) goto L89;
        Triple<String, String, String> r117 = r116.getSuggests();
        if (r117 == null) goto L89;
        r8 = ((ArrayList) com.larus.bot.impl.feature.edit.feature.firstmet.k.c(r117)).size();
    L89:
        BotEditParam r118 = r1.getEditParam();
        if (r118 == null) goto L94;
        Boolean r119 = r118.getSuggestSwitch();
        if (r119 == null) goto L94;
        r11 = r119.booleanValue();
    L94:
        ru8.f r120 = L2();
        if (r120 == null) goto L97;
        Boolean r121 = Boolean.valueOf(r120.lC());
    L98:
        BotEditParam r122 = r1.getEditParam();
        if (r122 == null) goto L101;
        r9 = r122.getBio();
    L101:
        boolean r28 = com.larus.utils.o0.d(r9);
        boolean r123 = r1.hasUsedPolishDesc();
        String r124 = r1.getPolishStatus();
        String r125 = r1.getPrivateStatusString();
        boolean r29 = r1.getPolishUseInternet();
        Boolean r126 = Boolean.FALSE;
        Boolean r127 = Boolean.valueOf(r115);
        Integer r30 = Integer.valueOf(r8);
        Boolean r31 = Boolean.valueOf(r11);
        Boolean r32 = Boolean.valueOf(r22);
        Boolean r33 = Boolean.valueOf(r28);
        Boolean r128 = Boolean.valueOf(r123);
        Boolean r34 = Boolean.valueOf(r29);
        JSONObject r129 = new JSONObject();
        Intrinsics.checkNotNullParameter(r129, "params");
        if (r24 != null) goto L183;
    L106:
        r129.put("current_page", "bot_description_modify_page");     // Catch: JSONException -> L104
        r129.put("previous_page", r4);     // Catch: JSONException -> L104
        if (r2 == null) goto L109;
        r129.put("draft_id", r2);     // Catch: JSONException -> L104
    L109:
        String r35 = TriggerSendLoading.NO_LOADING;
        if (r33 != null) goto L112;
    L116:
        if (r121 != null) goto L118;
    L122:
        if (r126 != null) goto L124;
    L128:
        if (r127 != null) goto L130;
    L134:
        if (r30 == null) goto L136;
        r129.put("sp_cnt", r30.intValue());     // Catch: JSONException -> L104
    L136:
        if (r31 != null) goto L138;
    L142:
        r129.put("profile_photo_type", r7);     // Catch: JSONException -> L104
        r129.put("image_type", r12);     // Catch: JSONException -> L104
        if (r32 != null) goto L145;
    L149:
        if (r27 == null) goto L151;
        r129.put("voice_id", r27);     // Catch: JSONException -> L104
    L151:
        if (r112 == null) goto L153;
        r129.put("voice_type", r112);     // Catch: JSONException -> L104
    L153:
        if (r128 != null) goto L155;
    L159:
        if (r124 == null) goto L161;
        String r36 = r124;
        r129.put("polish_status", r36);     // Catch: JSONException -> L104
    L162:
        if (r125 == null) goto L164;
        r129.put("private_status", r125);     // Catch: JSONException -> L104
    L164:
        if (r34 == null) goto L172;
        boolean r37 = r34.booleanValue();     // Catch: JSONException -> L104
        if (Intrinsics.areEqual(r36, "1") == false) goto L172;
        if (r37 == false) goto L170;
        Object r38 = "1";
    L171:
        r129.put("if_polish_use_internet", r38);     // Catch: JSONException -> L104
        goto L172
    L170:
        r38 = TriggerSendLoading.NO_LOADING;
    L172:
        if (r126 == null) goto L181;
        boolean r39 = r126.booleanValue();     // Catch: JSONException -> L104
        if (Intrinsics.areEqual(r126, Boolean.TRUE) == false) goto L181;
        if (r39 == false) goto L178;
        r35 = "1";
    L178:
        r129.put("if_auto_fill_use_internet", r35);     // Catch: JSONException -> L104
    L104:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper click_bot_description_modify_complete " + e.getLocalizedMessage());
    L181:
        TrackParams r40 = new TrackParams().merge(r129);
        by7.a r41 = new by7.a("click_bot_description_modify_complete");
        r41.a.merge(r40);
        r41.b();
        return;
    L161:
        r36 = r124;
        goto L162
    L155:
        if (r128.booleanValue() == false) goto L157;
        Object r42 = "1";
    L158:
        r129.put("if_polish", r42);     // Catch: JSONException -> L104
        goto L159
    L157:
        r42 = TriggerSendLoading.NO_LOADING;
        goto L158
    L145:
        if (r32.booleanValue() == false) goto L147;
        Object r43 = "1";
    L148:
        r129.put("background_status", r43);     // Catch: JSONException -> L104
        goto L149
    L147:
        r43 = TriggerSendLoading.NO_LOADING;
        goto L148
    L138:
        if (r31.booleanValue() == false) goto L140;
        Object r44 = "1";
    L141:
        r129.put("sp_status", r44);     // Catch: JSONException -> L104
        goto L142
    L140:
        r44 = TriggerSendLoading.NO_LOADING;
        goto L141
    L130:
        if (r127.booleanValue() == false) goto L132;
        Object r45 = "1";
    L133:
        r129.put("if_has_onboarding", r45);     // Catch: JSONException -> L104
        goto L134
    L132:
        r45 = TriggerSendLoading.NO_LOADING;
        goto L133
    L124:
        if (r126.booleanValue() == false) goto L126;
        Object r46 = "1";
    L127:
        r129.put("if_auto_filled", r46);     // Catch: JSONException -> L104
        goto L128
    L126:
        r46 = TriggerSendLoading.NO_LOADING;
        goto L127
    L118:
        if (r121.booleanValue() == false) goto L120;
        Object r47 = "1";
    L121:
        r129.put("is_guidance", r47);     // Catch: JSONException -> L104
        goto L122
    L120:
        r47 = TriggerSendLoading.NO_LOADING;
        goto L121
    L112:
        if (r33.booleanValue() == false) goto L114;
        Object r48 = "1";
    L115:
        r129.put("if_has_bio", r48);     // Catch: JSONException -> L104
        goto L116
    L114:
        r48 = TriggerSendLoading.NO_LOADING;
        goto L115
    L183:
        r129.put("bot_id", r24);     // Catch: JSONException -> L104
        goto L106
    L97:
        r121 = null;
        goto L98
    L83:
        r114 = null;
        goto L84
    L79:
        r111 = null;
    L75:
        r27 = null;
        goto L76
    L69:
        r24 = null;
    L65:
        r22 = false;
        goto L66
    L15:
        if (StringsKt.isBlank(r5.getIconUri()) == true) goto L35;
        BgImage r49 = r5.getBgImage();
        if (r49 == null) goto L22;
        BgImageInfo r50 = r49.bgImageInfo;
        if (r50 == null) goto L22;
        boolean r51 = Intrinsics.areEqual(r50.getAiGenBgImg(), Boolean.TRUE);
    L23:
        if (r51 == true) goto L34;
        ru8.f r52 = L2();
        if (r52 == null) goto L29;
        BotModel r53 = r52.FH();
        if (r53 == null) goto L29;
        String r54 = r53.getIconPrompt();
    L31:
        if (com.larus.utils.o0.d(r54) == true) goto L34;
        r7 = "uploaded";
    L29:
        r54 = null;
    L34:
        r7 = "ai_generate";
    L22:
        r51 = false;
    L11:
        r4 = "bot_setting";
        goto L12
    L186:
        return;
    }

    public final Unit N2(boolean r3) {
        ru8.e r0 = F2();
        if (r0 == null) goto L19;
        LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L19;
        ru8.f r2 = L2();
        if (r2 == null) goto L21;
        BotUpdateViewModel r4 = r2.c50();
        if (r4 == null) goto L21;
        if (r4.getCanAddBgImage() == false) goto L17;
        r1.i.setEnabled(r3);
        if (r3 == false) goto L16;
        r1.i.setAlpha(1.0f);
        goto L21
    L16:
        r1.i.setAlpha(0.3f);
        goto L21
    L17:
        r1.K.setRightTextEnable(r3);
    L21:
        return Unit.INSTANCE;
    L19:
        return null;
    }

    @Override // ru8.g
    public final void pq(BotModel r12) {
        ru8.e r0 = F2();
        if (r0 == null) goto L17;
        LifecycleOwner r1 = r0.s4();
        if (r1 == null) goto L19;
        ru8.f r2 = L2();
        if (r2 == null) goto L18;
        BotUpdateViewModel r3 = r2.c50();
        if (r3 == null) goto L20;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r4 == null) goto L15;
        r4.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("bot_update_result", r12)})));
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new BotUpdateButtonComponent$handleUpdateSuccess$1(r3, r12, this, null), 3, null);
        return;
    L20:
        return;
    L18:
        return;
    L19:
        return;
    }
}
