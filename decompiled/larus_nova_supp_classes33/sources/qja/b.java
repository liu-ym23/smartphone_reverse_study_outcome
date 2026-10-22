package qja;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import fna.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends qja.a {
    public MediaPlayer e;
    public final MediaMetadataRetriever f;
    public String g;

    public static final class a implements MediaPlayer.OnCompletionListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r1) {
            qja.c.a r2 = this.a.a;
            if (r2 == null) goto L6;
            r2.onCompletion();
            return;
        }
    }

    /* JADX INFO: renamed from: qja.b$b, reason: collision with other inner class name */
    public static final class C0067b implements MediaPlayer.OnPreparedListener {
        public final /* synthetic */ b a;

        public C0067b(b r1) {
            this.a = r1;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r1) {
            qja.c.d r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.onPrepared();
            return;
        }
    }

    public static final class c implements MediaPlayer.OnErrorListener {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r1, int r2, int r3) {
            qja.c.b r4 = this.a.c;
            if (r4 == null) goto L7;
            r4.onError();
            return false;
        L7:
            return false;
        }
    }

    public static final class d implements MediaPlayer.OnInfoListener {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer r1, int r2, int r3) {
            if (r2 != 3) goto L9;
            qja.c.InterfaceC0068c r4 = this.a.d;
            if (r4 == null) goto L10;
            r4.onFirstFrame();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    @Override // qja.c
    public final void a() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.setScreenOnWhilePlaying(true);
    }

    @Override // qja.c
    public final void b() {
        MediaPlayer r0 = new MediaPlayer();
        this.e = r0;
        r0.setOnCompletionListener(new a(this));
        MediaPlayer r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setOnPreparedListener(new C0067b(this));
        MediaPlayer r2 = this.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r2.setOnErrorListener(new c(this));
        MediaPlayer r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        r3.setOnInfoListener(new d(this));
    }

    @Override // qja.c
    public final void c() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.setLooping(false);
    }

    @Override // qja.c
    public final void d() {
        Intrinsics.checkNotNullParameter("nullnull", "dataPath");
        this.g = "nullnull";
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.setDataSource("nullnull");
    }

    @Override // qja.c
    public final pja.c getVideoInfo() {
        String r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L19;
        MediaMetadataRetriever r1 = this.f;
        String r2 = this.g;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L10:
        r1.setDataSource(r2);
        String r3 = i(this.f, 18);
        String r4 = i(this.f, 19);
        if (TextUtils.isEmpty(r3) == true) goto L17;
        if (TextUtils.isEmpty(r4) == true) goto L17;
        String r5 = i(this.f, 18);
        Intrinsics.checkNotNull(r5);
        int r6 = CastIntegerProtector.parseInt(r5);
        String r7 = i(this.f, 19);
        Intrinsics.checkNotNull(r7);
        return new pja.c(r6, CastIntegerProtector.parseInt(r7));
    L17:
        throw new Exception("DefaultSystemPlayer get metadata failure!");
    L19:
        throw new Exception("dataPath is null, please set setDataSource firstly!");
    }

    @Override // qja.c
    public final void pause() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r0.pause();
        return;
    L8:
        r0.pause();
        gna.a.a(r0.hashCode());
    }

    @Override // qja.c
    public final void prepareAsync() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.prepareAsync();
    }

    @Override // qja.c
    public final void release() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.release();
        this.g = "";
    }

    @Override // qja.c
    public final void reset() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.reset();
        this.g = "";
    }

    @Override // qja.c
    public final void start() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r0.start();
        return;
    L8:
        r0.start();
        gna.a.c(r0.hashCode());
    }

    @Override // qja.c
    public final void stop() {
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r0.stop();
        return;
    L8:
        r0.stop();
        gna.a.a(r0.hashCode());
    }

    public b() {
        this.f = new MediaMetadataRetriever();
    }

    @Override // qja.c
    public final void setSurface(Surface r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        MediaPlayer r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.setSurface(r3);
    }

    public static String i(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
