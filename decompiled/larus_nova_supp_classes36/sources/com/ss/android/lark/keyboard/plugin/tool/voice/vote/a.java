package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.myai.export.model.DownVoteFeedbackParam;
import com.ss.android.lark.pb.ai_engine.FeedsbackData;
import com.suite.lark.platform.component.dyres.DyResUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import osb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends d {
    public final FeedbackReasonDataConfig l;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.vote.a$a, reason: collision with other inner class name */
    public static final class C0163a implements osb.e {
        public final /* synthetic */ DownVoteFeedbackParam a;

        public C0163a(DownVoteFeedbackParam r1) {
            this.a = r1;
        }

        @Override // osb.e
        public final void a(UDButton r3, FeedsbackData r4, List<String> r5) {
            Intrinsics.checkNotNullParameter(r4, "feedsBackData");
            Intrinsics.checkNotNullParameter(r5, "reasonList");
            DownVoteFeedbackParam r6 = this.a;
            f r0 = r6.b;
            if (r0 == null) goto L6;
            r0.a(r3, r4.mextra, r4, r6);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.vote.d
    public final void a() {
        Locale r0 = KeyboardVoiceModule.a().getCurrentLocale();
        String r1 = r0.getCountry();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L14;
        String r3 = r0.getLanguage();
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = this.l.getDislikeReasons().iterator();
    L17:
        if (r5.hasNext() == false) goto L29;
        FeedbackReasonDataConfig.DislikeReason r6 = (FeedbackReasonDataConfig.DislikeReason) r5.next();
        String r7 = r6.getId();
        if (r6.getName().containsKey(r3) == false) goto L24;
        String r8 = r6.getName().get(r3);
        if (r8 != null) goto L28;
    L27:
        r8 = "";
    L28:
        r4.add(new DownVoteReasonAdapter.b(r7, r8));
        goto L17
    L24:
        if (r6.getName().containsKey(DyResUtils.ResI18n.en_US) == false) goto L27;
        r8 = r6.getName().get(DyResUtils.ResI18n.en_US);
        if (r8 != null) goto L28;
    L29:
        DownVoteReasonAdapter r9 = this.h;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "reasonList");
        ((ArrayList) r9.b).clear();
        ((ArrayList) r9.b).addAll(r4);
        r9.notifyDataSetChanged();
        return;
    L14:
        r3 = r0.getLanguage() + '_' + r0.getCountry();
        goto L15
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public a(Context r2, FeedbackReasonDataConfig r3, DownVoteFeedbackParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "param");
        C0163a r0 = new C0163a(r4);
        super(r2, new ArrayList(), r0);
        this.l = r3;
    }
}
