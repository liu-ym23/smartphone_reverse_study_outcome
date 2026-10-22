package com.larus.bmhome.music.player;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements a.InterfaceC0021a {
    public final Context a;

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void FK() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lf() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lr() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void OK() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Pe(float r1, boolean r2) {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void UY() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void f20() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void hideLoadingView() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void mP(int r1, boolean r2) {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void showLoadingView() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void F6() {
        a.InterfaceC0021a.C0022a.b();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final CoroutineScope getScope() {
        return GlobalScope.INSTANCE;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final Context getViewContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void GP(Map<String, String> r1) {
        a.InterfaceC0021a.C0022a.d(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Ij(Map<String, String> r1) {
        a.InterfaceC0021a.C0022a.c(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void eb(Map<String, String> r1) {
        a.InterfaceC0021a.C0022a.a(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void r30(String r1, Map<String, String> r2) {
        a.InterfaceC0021a.C0022a.e(r1, r2);
    }
}
