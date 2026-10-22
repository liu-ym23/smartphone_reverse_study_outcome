package com.larus.uaigc.chat.markdown.video;

import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.uaigc.chat.markdown.video.statemanager.n;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final MDSingleVideoWidget a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final n g;

    public static final class a implements com.larus.uaigc.chat.markdown.video.statemanager.a {
        public final CoroutineScope a;
        public final String b;
        public final String c;
        public final String d;
        public final Boolean e;
        public final q0.a f;
        public final ChatPageContext g;
        public final /* synthetic */ j h;

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final ISketchLoadingController a() {
            return (ISketchLoadingController) this.h.b.getValue();
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
            return this.h.a.b;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final View getHostView() {
            return this.h.a.j;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final boolean l() {
            return this.h.a.n;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final ChatPageContext M1() {
            return this.g;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final String b() {
            return this.d;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final CoroutineScope c() {
            return this.a;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final Boolean d() {
            return this.e;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final q0.a f() {
            return this.f;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final String getBotId() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
        public final String getCurrentPage() {
            return this.c;
        }

        public a(j r2) {
            this.h = r2;
            MDSingleVideoWidget r3 = r2.a;
            GlobalScope r0 = r3.l;
            if (r0 != null) goto L5;
            r0 = GlobalScope.INSTANCE;
        L5:
            this.a = r0;
            this.b = r3.d;
            this.c = r3.f;
            this.d = r3.g;
            this.e = r3.e;
            this.f = r3.h;
            this.g = r3.i;
        }
    }

    public j(MDSingleVideoWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "singleVideoWidget");
        this.a = r2;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.b = LazyKt.lazy(r3, new b(this));
        this.c = LazyKt.lazy(r3, new c(this));
        this.d = LazyKt.lazy(r3, new d(this));
        this.e = LazyKt.lazy(r3, new e(this));
        this.f = LazyKt.lazy(r3, new f(this));
        this.g = new n();
    }
}
