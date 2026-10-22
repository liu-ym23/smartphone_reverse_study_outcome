package dv8;

import android.os.Bundle;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.bot.impl.feature.edit.feature.firstmet.k;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.UUID;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int g = 0;
    public final BotCreateViewModel a;
    public final Bundle b;
    public final String c;
    public final String d;
    public final String e;
    public String f;

    public static final class a {
        public static String a() {
            StringBuilder r0 = new StringBuilder();
            r0.append(UUID.randomUUID());
            r0.append('_');
            r0.append(System.currentTimeMillis());
            return r0.toString();
        }
    }

    /* JADX INFO: renamed from: dv8.b$b, reason: collision with other inner class name */
    public static final class C0105b {
        public final Boolean a;
        public final Integer b;
        public final Boolean c;

        public C0105b(Boolean r1, Integer r2, Boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final boolean a() {
        BgImage r0 = this.a.getEditParam().getBgImage();
        if (r0 == null) goto L9;
        BgImageInfo r1 = r0.bgImageInfo;
        if (r1 == null) goto L9;
        Boolean r2 = r1.getBgImgOpen();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final String c() {
        String r0 = this.b.getString("create_way", "");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String d() {
        String r2 = "";
        String r0 = this.b.getString("creation_id", "");
        if (r0 == null) goto L7;
        r2 = r0;
    L7:
        if (r2.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        String r3 = a.a();
        this.b.putString("creation_id", r3);
        return r3;
    L13:
        return r2;
    L9:
        r1 = false;
        goto L10
    }

    public final String e() {
        BgImage r0 = this.a.getEditParam().getBgImage();
        if (r0 == null) goto L7;
        BgImageInfo r1 = r0.bgImageInfo;
        if (r1 == null) goto L7;
        boolean r2 = Intrinsics.areEqual(r1.getAiGenBgImg(), Boolean.TRUE);
    L9:
        if (r2 == false) goto L12;
        return "ai_generate";
    L12:
        if (StringsKt.isBlank(this.a.getEditParam().getIconUri()) == false) goto L14;
        return "default";
    L14:
        String r3 = this.a.getEditParam().getIconUri();
        wu8.d r4 = this.a.getLatestAutoFilledBotAvatarData();
        if (r4 == null) goto L19;
        BotAvatarIconData r5 = r4.a;
        if (r5 == null) goto L19;
        String r6 = r5.getIconUri();
    L21:
        if (Intrinsics.areEqual(r3, r6) == true) goto L27;
        return "uploaded";
    L27:
        return "ai_generate";
    L19:
        r6 = null;
    L7:
        r2 = false;
        goto L9
    }

    public final String f() {
        String r0 = this.b.getString("enter_method", "");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final C0105b g() {
        FirstMet r0 = this.a.getFirstMetData();
        String r2 = r0.getPrologue();
        boolean r3 = true;
        Integer r4 = null;
        if (r2 == null) goto L5;
        Boolean r5 = Boolean.valueOf(!StringsKt.isBlank(r2));
    L6:
        List r6 = r0.getSuggests();
        if (r6 == null) goto L9;
        r4 = Integer.valueOf(r6.size());
    L9:
        Boolean r1 = r0.getSuggestSwitch();
        if (r1 == null) goto L13;
        r3 = r1.booleanValue();
    L13:
        return new C0105b(r5, r4, Boolean.valueOf(r3));
    L5:
        r5 = null;
        goto L6
    }

    public final String h() {
        String r2 = "";
        String r0 = this.b.getString("from_activity_module", "");
        if (r0 == null) goto L7;
        r2 = r0;
    L7:
        if (r2.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        return r2;
    L9:
        r1 = false;
        goto L10
    }

    public final String i() {
        String r2 = "";
        String r0 = this.b.getString("from_activity_name", "");
        if (r0 == null) goto L7;
        r2 = r0;
    L7:
        if (r2.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        return r2;
    L9:
        r1 = false;
        goto L10
    }

    public final boolean j() {
        return this.a.hasUsedAutoFill();
    }

    public final boolean k() {
        return this.a.hasUsedPolishDesc();
    }

    public final String l() {
        BgImage r0 = this.a.getEditParam().getBgImage();
        if (r0 == null) goto L5;
        String r1 = r0.bgImgUri;
    L6:
        if (r1 != null) goto L8;
        return "no_image";
    L8:
        BgImage r2 = this.a.getEditParam().getBgImage();
        if (r2 == null) goto L13;
        BgImageInfo r3 = r2.bgImageInfo;
        if (r3 == null) goto L13;
        boolean r4 = Intrinsics.areEqual(r3.getAiGenBgImg(), Boolean.TRUE);
    L14:
        if (r4 == false) goto L16;
        return "ai_generate";
    L16:
        return "uploaded";
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final int m() {
        return this.a.getPolishCnt();
    }

    public final String o() {
        String r2 = "";
        String r0 = this.b.getString("previous_page", "");
        if (r0 == null) goto L7;
        r2 = r0;
    L7:
        if (r2.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        return r2;
    L9:
        r1 = false;
        goto L10
    }

    public final boolean p() {
        return !StringsKt.isBlank(this.a.getEditParam().getBio());
    }

    public final boolean q() {
        String r1 = "";
        List r0 = CollectionsKt.listOf(new String[]{TriggerSendLoading.NO_LOADING, ""});
        SpeakerVoice r2 = this.a.getEditParam().getVoice();
        if (r2 == null) goto L5;
        String r3 = r2.getId();
    L6:
        if (r3 == null) goto L10;
        r1 = r3;
    L10:
        return !r0.contains(r1);
    L5:
        r3 = null;
        goto L6
    }

    public final String r() {
        if (StringsKt.isBlank(this.a.getEditParam().getName()) == false) goto L5;
        return "empty";
    L5:
        List<String> r0 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.NAME.getValue());
        if (r0 == null) goto L8;
        String r1 = (String) CollectionsKt.firstOrNull(r0);
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        return "manual_fill";
    L18:
        if (Intrinsics.areEqual(r1, this.a.getEditParam().getName()) == false) goto L20;
        return "auto_fill";
    L20:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final String s() {
        String r0 = this.a.getFirstMetData().getPrologue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return "empty";
    L10:
        List<String> r3 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.PROLOGUE.getValue());
        if (r3 == null) goto L13;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L14:
        if (r4 != null) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == false) goto L21;
        return "manual_fill";
    L21:
        if (Intrinsics.areEqual(r4, this.a.getEditParam().getPrologue()) == false) goto L23;
        return "auto_fill";
    L23:
        return "auto_fill_manual_change";
    L16:
        if (StringsKt.isBlank(r4) == false) goto L18;
    L13:
        r4 = null;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r0)) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final String t() {
        if (StringsKt.isBlank(this.a.getEditParam().getIconUri()) == false) goto L5;
        return "empty";
    L5:
        wu8.d r0 = this.a.getLatestAutoFilledBotAvatarData();
        if (r0 == null) goto L10;
        BotAvatarIconData r1 = r0.a;
        if (r1 == null) goto L10;
        String r2 = r1.getIconUri();
    L11:
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L20;
        return "manual_fill";
    L20:
        if (Intrinsics.areEqual(r2, this.a.getEditParam().getIconUri()) == false) goto L22;
        return "auto_fill";
    L22:
        return "auto_fill_manual_change";
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r3 = false;
    L10:
        r2 = null;
        goto L11
    }

    public final String v() {
        if (StringsKt.isBlank(this.a.getEditParam().getDescription()) == false) goto L5;
        return "empty";
    L5:
        List<String> r0 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.DESC.getValue());
        if (r0 == null) goto L8;
        String r1 = (String) CollectionsKt.firstOrNull(r0);
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        return "manual_fill";
    L18:
        if (j() == true) goto L21;
        return "manual_fill_polish";
    L21:
        if (Intrinsics.areEqual(r1, this.a.getEditParam().getDescription()) == false) goto L27;
        if (k() == false) goto L25;
        return "auto_fill_polish";
    L25:
        return "auto_fill";
    L27:
        if (k() == false) goto L29;
        return "auto_fill_polish_manual_change";
    L29:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final String w() {
        Triple<String, String, String> r0 = this.a.getEditParam().getSuggests();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return "empty";
    L10:
        List<String> r3 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.SUGGEST.getValue());
        Triple<String, String, String> r4 = this.a.getEditParam().getSuggests();
        Integer r5 = null;
        if (r4 == null) goto L13;
        List r6 = TuplesKt.toList(r4);
    L14:
        List<String> r7 = r3;
        if (r7 != null) goto L17;
    L20:
        if (r1 == false) goto L22;
        return "manual_fill";
    L22:
        if (r3 == null) goto L24;
        Integer r8 = Integer.valueOf(r3.size());
    L25:
        if (r6 == null) goto L28;
        r5 = Integer.valueOf(r6.size());
    L28:
        if (Intrinsics.areEqual(r8, r5) == false) goto L36;
        if (r3 != null) goto L31;
        r3 = CollectionsKt.emptyList();
    L31:
        if (r6 != null) goto L34;
        r6 = CollectionsKt.emptyList();
    L34:
        if (r3.containsAll(r6) == false) goto L36;
        return "auto_fill";
    L36:
        return "auto_fill_manual_change";
    L24:
        r8 = null;
        goto L25
    L17:
        if (r7.isEmpty() == true) goto L20;
        r1 = false;
        goto L20
    L13:
        r6 = null;
        goto L14
    L5:
        if (k.a(r0) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final String b() {
        if (p() == true) goto L5;
        return "empty";
    L5:
        List<String> r0 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.BIO.getValue());
        if (r0 == null) goto L8;
        String r1 = (String) CollectionsKt.firstOrNull(r0);
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        return "manual_fill";
    L18:
        if (Intrinsics.areEqual(r1, this.a.getEditParam().getBio()) == false) goto L20;
        return "auto_fill";
    L20:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final String n() {
        if (k() == true) goto L5;
        return null;
    L5:
        if (this.a.isPolishUndo() == false) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        return "1";
    }

    public final String x() {
        if (q() == true) goto L5;
        return "empty";
    L5:
        List<String> r0 = this.a.getLatestAutoFilledBotEnrichData().get(ContentType.VOICE_ID.getValue());
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = (String) CollectionsKt.firstOrNull(r0);
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return "manual_fill";
    L17:
        SpeakerVoice r4 = this.a.getEditParam().getVoice();
        if (r4 == null) goto L21;
        r1 = r4.getId();
    L21:
        if (Intrinsics.areEqual(r2, r1) == false) goto L23;
        return "auto_fill";
    L23:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r2) == true) goto L14;
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public b(BotCreateViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
        this.b = new Bundle();
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "create";
    }

    public final void u(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        if (Intrinsics.areEqual(r3, this.c) == true) goto L6;
        this.b.putString("create_way", r3);
        return;
    }
}
