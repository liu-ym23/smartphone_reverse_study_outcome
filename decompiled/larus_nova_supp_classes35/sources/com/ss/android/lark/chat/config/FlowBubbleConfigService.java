package com.ss.android.lark.chat.config;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import itb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v4b.b;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/config/FlowBubbleConfigService;", "Lcom/ss/android/lark/chat/config/IBubbleConfigService;", "<init>", "()V", "UNUSED", BuildConfig.FLAVOR, "assignColor", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "isDoubaoBUser", BuildConfig.FLAVOR, "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBubbleConfigService implements b {
    public static final int $stable = 0;
    private final int UNUSED;

    private final boolean isDoubaoBUser() {
        return ((a) LarkContext.spiByDwarf(a.class)).i1();
    }

    public FlowBubbleConfigService() {
        this.UNUSED = -1;
    }

    @Override // v4b.b
    public void assignColor(Context r18) {
        Intrinsics.checkNotNullParameter(r18, "context");
        v4b.a.a = UDColorUtils.getColor(r18, 2131102062);
        v4b.a.c = UDColorUtils.getColor(r18, 2131102062);
        v4b.a.y = 2131102063;
        v4b.a.U = 2131102062;
        v4b.a.b = j08.b.b(d.c(r18, 2131102446), 0.0f);
        v4b.a.d = d.c(r18, 2131108623);
        v4b.a.e = d.c(r18, 2131102067);
        v4b.a.f = d.c(r18, 2131102444);
        v4b.a.g = 2131106607;
        v4b.a.h = d.c(r18, 2131103353);
        v4b.a.i = j08.b.b(d.c(r18, 2131102066), 1.0f);
        v4b.a.j = j08.b.b(d.c(r18, 2131106616), 1.0f);
        j08.b.b(d.c(r18, 2131103404), 1.0f);
        j08.b.b(d.c(r18, 2131106521), 1.0f);
        j08.b.b(d.c(r18, 2131105580), 1.0f);
        v4b.a.k = 2131106607;
        j08.b.b(d.c(r18, 2131105580), 1.0f);
        j08.b.b(d.c(r18, 2131103463), 1.0f);
        v4b.a.l = 2131102454;
        v4b.a.m = 2131102456;
        v4b.a.n = j08.b.b(d.c(r18, 2131108730), 0.16f);
        v4b.a.o = 2131106620;
        v4b.a.p = d.c(r18, 2131108724);
        v4b.a.q = j08.b.b(d.c(r18, 2131103449), 0.8f);
        v4b.a.r = j08.b.b(d.c(r18, 2131108723), 0.5f);
        v4b.a.s = j08.b.b(d.c(r18, 2131103449), 0.5f);
        v4b.a.t = 2131106616;
        v4b.a.u = d.c(r18, 2131106622);
        v4b.a.v = d.c(r18, 2131102464);
        v4b.a.w = d.c(r18, 2131106607);
        v4b.a.z = UDColorUtils.getColor(r18, 2131102026);
        v4b.a.A = j08.b.b(d.c(r18, 2131102447), 0.0f);
        v4b.a.B = UDColorUtils.getColor(r18, 2131102440);
        v4b.a.C = d.c(r18, 2131108731);
        v4b.a.D = d.c(r18, 2131102042);
        v4b.a.E = d.c(r18, 2131102445);
        v4b.a.F = 2131106607;
        v4b.a.G = d.c(r18, 2131103353);
        v4b.a.H = j08.b.b(d.c(r18, 2131102042), 1.0f);
        v4b.a.I = j08.b.b(d.c(r18, 2131106616), 1.0f);
        j08.b.b(d.c(r18, 2131103404), 1.0f);
        j08.b.b(d.c(r18, 2131103449), 1.0f);
        j08.b.b(d.c(r18, 2131103406), 1.0f);
        v4b.a.J = 2131106607;
        j08.b.b(d.c(r18, 2131103406), 1.0f);
        j08.b.b(d.c(r18, 2131103463), 1.0f);
        v4b.a.K = 2131102454;
        v4b.a.L = 2131102456;
        v4b.a.M = j08.b.b(d.c(r18, 2131108730), 0.16f);
        v4b.a.N = d.c(r18, 2131108724);
        v4b.a.O = j08.b.b(d.c(r18, 2131103449), 0.8f);
        v4b.a.P = j08.b.b(d.c(r18, 2131108723), 0.5f);
        v4b.a.Q = j08.b.b(d.c(r18, 2131103449), 0.5f);
        v4b.a.R = d.c(r18, 2131106622);
        v4b.a.S = d.c(r18, 2131106607);
        v4b.a.x = 2131235425;
        v4b.a.T = 2131235426;
    }
}
