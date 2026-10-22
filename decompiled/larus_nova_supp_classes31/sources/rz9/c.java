package rz9;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.gallery.adapter.ui.i;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.uaigc.creation.gallery.datasource.j;
import com.larus.uaigc.creation.gallery.providers.CreationSideBarProvider;
import com.larus.uaigc.creation.gallery.providers.a0;
import com.larus.uaigc.creation.gallery.providers.y;
import com.larus.uaigc.service.ICreationAiEditService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jy9.x;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;
import v19.i5;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements jy9.a {
        public final /* synthetic */ x a;
        public final /* synthetic */ Context b;

        @Override // jy9.a
        public final void b() {
        }

        @Override // jy9.a
        public final com.larus.trace.tracknode.a f() {
            return null;
        }

        @Override // jy9.a
        public final q0 getAdapter() {
            return null;
        }

        @Override // jy9.a
        public final jy9.c a() {
            Function0<e> r0 = this.a.p;
            if (r0 == null) goto L7;
            e r1 = (e) r0.invoke();
            if (r1 == null) goto L7;
            String r2 = r1.a;
        L8:
            String r3 = "";
            if (r2 != null) goto L11;
            String r4 = "";
        L12:
            Function0<String> r5 = this.a.n;
            if (r5 == null) goto L15;
            String r6 = (String) r5.invoke();
        L16:
            if (r6 == null) goto L19;
            r3 = r6;
        L19:
            Function0<e> r7 = this.a.p;
            if (r7 == null) goto L22;
            e r8 = (e) r7.invoke();
        L23:
            x r9 = this.a;
            Function1<ICoreInputAbility.OnSendParams, Unit> r10 = r9.w;
            Function4<Serializable, String, String, zs8.a, Unit> r11 = r9.x;
            Function1<DialogFragment, Unit> r12 = r9.y;
            Function0<Unit> r13 = r9.z;
            if (r13 != null) goto L27;
            r13 = new rz9.a();
        L27:
            return new jy9.c(r4, r3, r8, r10, r11, r12, r13);
        L22:
            r8 = null;
            goto L23
        L15:
            r6 = null;
            goto L16
        L11:
            r4 = r2;
        L7:
            r2 = null;
            goto L8
        }

        @Override // jy9.a
        public final Function0<List<Message>> c() {
            return this.a.u;
        }

        @Override // jy9.a
        public final boolean d() {
            return this.a.q;
        }

        @Override // jy9.a
        public final Function4<g, String, Map<String, String>, Map<String, String>, Unit> e() {
            final Function4<g, String, Map<String, String>, Map<String, String>, Unit> r0 = this.a.t;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new b(r0);
        }

        @Override // jy9.a
        public final Fragment g() {
            return this.a.l;
        }

        @Override // jy9.a
        public final Message getMessage() {
            return this.a.a;
        }

        @Override // jy9.a
        public final CoroutineScope getScope() {
            return this.a.h;
        }

        @Override // jy9.a
        public final BotModel i() {
            Function0<BotModel> r0 = this.a.o;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (BotModel) r0.invoke();
        }

        @Override // jy9.a
        public Context getContext() {
            return this.b;
        }

        public a(x r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static void a(Context r18, FragmentManager r19, x r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "fragmentManager");
        Intrinsics.checkNotNullParameter(r20, "galleryContext");
        int r3 = jy9.d.a;
        a r4 = new a(r20, r18);
        Intrinsics.checkNotNullParameter(r4, "aiEditContext");
        jy9.e r5 = ICreationAiEditService.a.a(r4);
        Pair r6 = IChatGalleryService.a.a(r18);
        GalleryBuilder r7 = new GalleryBuilder(r18);
        j r0 = new j(r20);
        Intrinsics.checkNotNullParameter(r0, "dataSource");
        r7.b = r0;
        Intrinsics.checkNotNullParameter("ChatGalleryDialog", "tag");
        r7.m = "ChatGalleryDialog";
        int r1 = r20.g;
        if (r1 < 0) goto L5;
        r7.c = r1;
    L5:
        com.larus.gallery.api.b r2 = new com.larus.gallery.api.b(new com.larus.gallery.api.a(((Number) r6.getFirst()).intValue(), ((Number) r6.getSecond()).intValue(), DisplayGravity.TOP, new i(i5.Z())), false, null, z2.a.getNewPreviewConfig().b.b, false, false, false, null, null, false, 32510);
        Intrinsics.checkNotNullParameter(r2, "displayConfig");
        r7.d = r2;
        r7.a(ProviderType.TOP, new y(r20));
        r7.a(ProviderType.BOTTOM, new com.larus.uaigc.creation.gallery.providers.c(r20, r5));
        r7.a(ProviderType.RIGHT_SIDE, new CreationSideBarProvider(r5));
        r7.a(ProviderType.NON_UI, new a0());
        r7.l = r20.k;
        r7.b(r19);
    }
}
