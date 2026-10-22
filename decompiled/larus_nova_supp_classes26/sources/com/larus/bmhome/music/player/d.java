package com.larus.bmhome.music.player;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements ad9.b {
    public final String b;
    public MusicCreationContent c;
    public MusicCreationContent d;
    public final MutableSharedFlow<ad9.b.b> e;

    public static final class a {
        public MusicCreationContent a;
        public final MutableSharedFlow<ad9.b.b> b;

        public a() {
            this.b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        }
    }

    public final String a() {
        return "Creation";
    }

    public final boolean c() {
        return false;
    }

    public final boolean getHasNext() {
        return true;
    }

    public final boolean getHasPrevious() {
        return true;
    }

    public final String getItemId() {
        return TriggerSendLoading.NO_LOADING;
    }

    public final MutableSharedFlow<ad9.b.b> b() {
        return this.e;
    }

    public final MusicCreationContent d() {
        return this.d;
    }

    public final MusicCreationContent getNext() {
        return this.c;
    }

    public final String getVid() {
        return this.b;
    }

    public d(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "bindDecorator");
        Intrinsics.checkNotNullParameter(r3, "vidPlay");
        this.b = r3;
        this.e = r2.b;
    }
}
