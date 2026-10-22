package com.larus.bmhome.music.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LyricsToSongCardView$rebindListener$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public LyricsToSongCardView$rebindListener$1(Object r8) {
        super(0, r8, LyricsToSongCardView.class, "rebind", "rebind()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m14invoke() {
        LyricsToSongCardView r1 = (LyricsToSongCardView) ((CallableReference) this).receiver;
        LyricsToSongCardView.j(r1, r1.i, r1.k, r1.j, r1.m, r1.n, r1.l, null, 64);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m14invoke();
        return Unit.INSTANCE;
    }
}
