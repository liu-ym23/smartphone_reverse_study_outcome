package com.larus.bmhome.music.player;

import android.content.Context;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.music.player.a$a, reason: collision with other inner class name */
    public interface InterfaceC0021a {

        /* JADX INFO: renamed from: com.larus.bmhome.music.player.a$a$a, reason: collision with other inner class name */
        public static final class C0022a {
            public static void b() {
                GlobalAudioObserver.a.f("text_generate_music", null, null);
                AudioServiceDelegate.a.O().a(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void a(Map r3) {
                Intrinsics.checkNotNullParameter(r3, "bizExtra");
                GlobalAudioObserver.a.c("text_generate_music", GlobalAudioStateEnum.STOPPED, r3);
                AudioServiceDelegate.a.O().c(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void c(Map r3) {
                Intrinsics.checkNotNullParameter(r3, "bizExtra");
                GlobalAudioObserver.a.c("text_generate_music", GlobalAudioStateEnum.PAUSED, r3);
            }

            public static void d(Map r1) {
                Intrinsics.checkNotNullParameter(r1, "bizExtra");
                AudioServiceDelegate.a.O().e(SoundsSource.TEXT_GENERATED_MUSIC);
            }

            public static void e(String r2, Map r3) {
                Intrinsics.checkNotNullParameter(r2, "uniId");
                Intrinsics.checkNotNullParameter(r3, "bizExtra");
                GlobalAudioObserver r0 = GlobalAudioObserver.a;
                r0.e("text_generate_music", r2, r3);
                r0.c("text_generate_music", GlobalAudioStateEnum.PLAYING, r3);
            }
        }

        void F6();

        void FK();

        void GP(Map<String, String> r1);

        void Ij(Map<String, String> r1);

        void Lf();

        void Lr();

        void OK();

        void Pe(float r1, boolean r2);

        void UY();

        void eb(Map<String, String> r1);

        void f20();

        CoroutineScope getScope();

        Context getViewContext();

        void hideLoadingView();

        void mP(int r1, boolean r2);

        void r30(String r1, Map<String, String> r2);

        void showLoadingView();
    }

    boolean a();

    void b(float r1);

    void c();

    void d(j r1);

    j data();

    void e(j r1);

    void f(boolean r1, boolean r2);

    void g();

    void h(boolean r1);

    void i();

    boolean isStreaming();

    int j(String r1, Function1<? super Integer, Unit> r2);

    void k(boolean r1);

    void onAttachedToWindow();

    void onDestroyed();

    void onDetachedFromWindow();

    void onPaused();

    void onResumed();

    void seekTo(int r1);
}
