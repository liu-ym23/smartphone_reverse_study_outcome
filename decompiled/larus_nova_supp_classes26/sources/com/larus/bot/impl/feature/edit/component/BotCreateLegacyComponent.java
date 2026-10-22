package com.larus.bot.impl.feature.edit.component;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.StaticLayout;
import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.im.bean.bot.BgImage;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0018J&\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0018J\u000f\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010!\u001a\u00020\u0015H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotCreateLegacyComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bot/impl/feature/ability/IBotCreateLegacyAbility;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botCreateAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "getBotCreateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "botCreateAbility$delegate", "descMinHeight", "", "descMaxHeight", "onAttach", "", "onParentViewCreated", "setupHeader", "()Lkotlin/Unit;", "fillAvatar", ShareType.URL, "", "uri", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "setupDescriptionEdit", "adjustDescEditHeight", "setupSwitchConfig", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateLegacyComponent extends ComponentFeature implements ru8.c {
    public static final /* synthetic */ int l = 0;
    public final Lazy h;
    public final Lazy i;
    public int j;
    public int k;

    public static final class a {
    }

    static {
    }

    public final void B2() {
        ru8.e r0 = (ru8.e) this.h.getValue();
        String r4 = "";
        Job r6 = null;
        if (r0 == null) goto L49;
        LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L49;
        ru8.a r7 = (ru8.a) this.i.getValue();
        if (r7 == null) goto L48;
        BotCreateViewModel r8 = r7.a1();
        if (r8 == null) goto L48;
        ru8.e r9 = (ru8.e) this.h.getValue();
        if (r9 == null) goto L20;
        LarusPageBotEditBinding r10 = r9.e();
        if (r10 == null) goto L20;
        if (Build.VERSION.SDK_INT < 28) goto L19;
        int r11 = com.larus.utils.i.d(getContext()) - c7.b(64);
        String r12 = getContext().getResources().getString(2131901106);
        StaticLayout r13 = com.larus.bot.impl.common.util.j.b(r10.o, r12 + '\n' + r12 + '\n' + r12 + '\n' + r12, r11);
        StaticLayout r14 = com.larus.bot.impl.common.util.j.b(r10.o, r12 + '\n' + r12 + '\n' + r12 + '\n' + r12 + '\n' + r12 + '\n' + r12 + '\n' + r12 + '\n' + r12, r11);
        this.j = r13.getHeight();
        this.k = r14.getHeight();
        r10.o.setMinHeight(this.j);
        r10.o.setMaxHeight(this.k);
    L19:
        Unit r15 = Unit.INSTANCE;
    L20:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r16 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r16 == null) goto L27;
        com.larus.bot.impl.feature.botmaker.k r17 = com.larus.bot.impl.feature.botmaker.k.a;
        BotMakerDataModel r18 = com.larus.bot.impl.feature.botmaker.k.d(r16.getString("bot_create_info"));
        if (r18 == null) goto L25;
        String r19 = r18.getRole();
    L26:
        if (r19 == null) goto L27;
    L28:
        String r20 = StringsKt.trim(r19).toString();
        final Context r21 = getContext();
        if (r21 == null) goto L31;
        r1.o.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r21.getResources().getInteger(2131427365), new v(r21))});
    L31:
        r1.o.setText(r20);
        r8.updateDescription(r20);
        if (r20.length() <= 0) goto L34;
        boolean r22 = true;
    L35:
        if (r22 == false) goto L38;
        r8.onBotInfoChanged(ContentType.DESC, false);
    L38:
        if (AccountService.a.isLogin().booleanValue() == true) goto L40;
    L47:
        r1.o.addTextChangedListener(new b0(r8));
        com.larus.bot.impl.common.util.j.a(r1.o);
        goto L48
    L40:
        if (r20.length() != 0) goto L42;
        boolean r23 = true;
    L43:
        if (r23 == false) goto L47;
        tu8.a.a.getClass();
        Keva r24 = tu8.a.b;
        String r110 = r24.getString("key_create_bot_desc", null);
        if (com.larus.utils.o0.d(r110) == false) goto L47;
        r1.o.setText(r110);
        Intrinsics.checkNotNull(r110);
        r8.updateDescription(r110);
        r24.erase("key_create_bot_desc");
        goto L47
    L42:
        r23 = false;
        goto L43
    L34:
        r22 = false;
        goto L35
    L25:
        r19 = null;
    L27:
        r19 = "";
    L48:
        Unit r2 = Unit.INSTANCE;
    L49:
        ru8.e r3 = (ru8.e) this.h.getValue();
        if (r3 != null) goto L52;
    L151:
        ru8.e r5 = (ru8.e) this.h.getValue();
        if (r5 == null) goto L174;
        LarusPageBotEditBinding r25 = r5.e();
        if (r25 == null) goto L175;
        ru8.a r26 = (ru8.a) this.i.getValue();
        if (r26 == null) goto L176;
        final BotCreateViewModel r27 = r26.a1();
        if (r27 == null) goto L177;
        FeatureKitDelegate r28 = FeatureKitDelegate.b;
        if (r28.b0().b() == false) goto L167;
        r25.L.setVisibility(0);
        if (r28.b0().c() == false) goto L165;
        r27.updateWebSearch(true);
        goto L167
    L165:
        r27.updateWebSearch(false);
        r25.L.getToggleView().setChecked(false);
    L167:
        if (r28.a0().b() == false) goto L172;
        r25.r.setVisibility(0);
        if (r28.a0().c() == false) goto L171;
        r27.updateGenPic(true);
        goto L172
    L171:
        r27.updateGenPic(false);
        r25.r.getToggleView().setChecked(false);
    L172:
        r25.L.getToggleView().setOnCheckedChangeListener(new y(r27));
        r25.r.getToggleView().setOnCheckedChangeListener(new z(r27));
        return;
    L177:
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L52:
        if (r3.e() == null) goto L151;
        ru8.a r29 = (ru8.a) this.i.getValue();
        if (r29 == null) goto L150;
        final BotCreateViewModel r111 = r29.a1();
        if (r111 == null) goto L150;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r30 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r30 == null) goto L64;
        String r31 = r30.getString("bot_create_msg_id");
        if (r31 == null) goto L64;
        final String r32 = r31;
    L65:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r33 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r33 == null) goto L68;
        r33.getString("bot_create_cvs_id");
    L68:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r34 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r34 == null) goto L74;
        String r35 = r34.getString("bot_create_info");
        if (r35 == null) goto L74;
        r4 = r35;
    L74:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r36 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r36 == null) goto L78;
        r36.getInt("bot_create_msg_index");
    L78:
        if (com.larus.utils.o0.d(r32) == false) goto L151;
        r111.refreshAvatarLoading(true);
        final Ref.ObjectRef r37 = new Ref.ObjectRef();
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        final Ref.ObjectRef r113 = new Ref.ObjectRef();
        com.larus.bot.impl.feature.botmaker.k r38 = com.larus.bot.impl.feature.botmaker.k.a;
        BotMakerDataModel r39 = com.larus.bot.impl.feature.botmaker.k.d(r4);
        if (r39 == null) goto L82;
        String r40 = r39.getIcon_url();
    L83:
        r37.element = r40;
        if (r39 == null) goto L86;
        String r41 = r39.getIcon_uri();
    L87:
        r112.element = r41;
        if (r111.getCanAddBgImage() == false) goto L93;
        if (r39 == null) goto L91;
        BgImage r42 = r39.getBgImage();
    L92:
        r113.element = r42;
        goto L93
    L91:
        r42 = null;
    L93:
        CharSequence r43 = (CharSequence) r37.element;
        if (r43 != null) goto L96;
    L99:
        boolean r44 = true;
    L101:
        if (r44 == true) goto L120;
        CharSequence r45 = (CharSequence) r112.element;
        if (r45 != null) goto L105;
    L108:
        boolean r46 = true;
    L109:
        if (r46 == true) goto L120;
        if (Intrinsics.areEqual(r37.element, "placeholder") == false) goto L114;
    L118:
        r111.refreshAvatarLoading(false);
        goto L150
    L114:
        if (Intrinsics.areEqual(r112.element, "placeholder") == true) goto L118;
        String r47 = (String) r37.element;
        if (r47 == null) goto L118;
        F2(r47, (String) r112.element, (BgImage) r113.element);
        r111.onBotInfoChanged(ContentType.BG_IMG_PROMPT, false);
        goto L118
    L105:
        if (r45.length() == 0) goto L108;
        r46 = false;
    L120:
        if (r32.length() != 0) goto L122;
        boolean r48 = true;
    L123:
        if (r48 == true) goto L128;
        Map<String, Job> r49 = com.larus.bot.impl.feature.botmaker.k.f;
        if (r49.containsKey(r32) == false) goto L128;
        r6 = (Job) ((LinkedHashMap) r49).get(r32);
    L128:
        if (r6 != null) goto L130;
    L132:
        boolean r50 = false;
    L133:
        if (r50 == true) goto L137;
        if (r6 == null) goto L137;
        r6.invokeOnCompletion(new u(r37, r32, r112, r111, r113, this));
    L137:
        Intrinsics.checkNotNullParameter(r32, "msgId");
        r37.element = (String) ((LinkedHashMap) com.larus.bot.impl.feature.botmaker.k.h).get(r32);
        Intrinsics.checkNotNullParameter(r32, "msgId");
        r112.element = (String) ((LinkedHashMap) com.larus.bot.impl.feature.botmaker.k.i).get(r32);
        if (r111.getCanAddBgImage() == false) goto L141;
        Intrinsics.checkNotNullParameter(r32, "msgId");
        r113.element = (BgImage) ((LinkedHashMap) com.larus.bot.impl.feature.botmaker.k.j).get(r32);
    L141:
        if (com.larus.utils.o0.d((String) r37.element) == true) goto L143;
    L149:
        r111.refreshAvatarLoading(false);
        goto L150
    L143:
        if (Intrinsics.areEqual(r37.element, "placeholder") == true) goto L149;
        if (com.larus.utils.o0.d((String) r112.element) == false) goto L149;
        if (Intrinsics.areEqual(r112.element, "placeholder") == true) goto L149;
        F2((String) r37.element, (String) r112.element, (BgImage) r113.element);
        r111.onBotInfoChanged(ContentType.BG_IMG_PROMPT, false);
        goto L149
    L130:
        if (r6.isCompleted() != true) goto L132;
        r50 = true;
        goto L133
    L122:
        r48 = false;
        goto L123
    L96:
        if (r43.length() == 0) goto L99;
        r44 = false;
        goto L101
    L86:
        r41 = null;
        goto L87
    L82:
        r40 = null;
    L64:
        r32 = "";
    L150:
        Unit r51 = Unit.INSTANCE;
        goto L151
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ru8.c.class);
    }

    public BotCreateLegacyComponent() {
        this.h = LazyKt.lazy(new w(this));
        this.i = LazyKt.lazy(new x(this));
        this.j = c7.b(100);
        this.k = c7.b(196);
    }

    @Override // ru8.c
    public final int SG() {
        return this.k;
    }

    @Override // ru8.c
    public final int pk() {
        return this.j;
    }

    public final void F2(String r3, String r4, BgImage r5) {
        ru8.e r0 = (ru8.e) this.h.getValue();
        if (r0 == null) goto L5;
        LarusPageBotEditBinding r1 = r0.e();
    L6:
        ru8.a r2 = (ru8.a) this.i.getValue();
        if (r2 == null) goto L19;
        BotCreateViewModel r6 = r2.a1();
        if (r6 == null) goto L23;
        if (r1 == null) goto L20;
        if (r3 == null) goto L21;
        if (r4 == null) goto L22;
        r6.updateIconUri(r3, r4);
        r6.updateOriginalAvatarImgUri(r3);
        if (r5 == null) goto L17;
        r6.updateBgImage(r5);
        r6.updateOriginalBackgroundImgUri(r5.bgImgUrl);
    L17:
        r6.refreshAvatar();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L23:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
