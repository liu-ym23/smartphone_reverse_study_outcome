package bq8;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable(with = b.class)
public final class a extends MusicCreationContent {
    public static final C0003a Companion = null;
    public long a;
    public String b;
    public final long c;
    public String d;
    public int e;

    /* JADX INFO: renamed from: bq8.a$a, reason: collision with other inner class name */
    public static final class C0003a {
        public C0003a() {
        }

        public final juc.d<a> serializer() {
            return b.a;
        }
    }

    public a() {
        super(1);
        this.b = "";
    }

    public final int getType() {
        return 0;
    }

    static {
        Companion = new C0003a();
    }

    public final d b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        ouc.a.a r1 = ouc.a.d;     // Catch: Throwable -> L7
        juc.c r2 = d.Companion.serializer();     // Catch: Throwable -> L7
        String r3 = this.b;     // Catch: Throwable -> L7
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Object r4 = Result.constructor-impl((d) r1.c(r2, r3));     // Catch: Throwable -> L7
    L9:
        d r5 = new d();
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = r5;
    L13:
        return (d) r4;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public a(c r23) {
        Intrinsics.checkNotNullParameter(r23, "surrogate");
        this();
        String r2 = r23.a;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        setVid(r2);
        String r4 = r23.b;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        setVideoModel(r4);
        String r5 = r23.c;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        setShareInfo(r5);
        String r6 = r23.d;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        setCreator(r6);
        String r7 = r23.e;
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        setLyrics(r7);
        String r8 = r23.f;
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        setLyricsSeekContent(r8);
        String r9 = r23.g;
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        setTitle(r9);
        Boolean r10 = r23.h;
        boolean r11 = false;
        if (r10 == null) goto L26;
        boolean r12 = r10.booleanValue();
    L27:
        setTitleEdited(r12);
        Image r13 = r23.i;
        if (r13 != null) goto L30;
        r13 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L30:
        setCover(r13);
        Boolean r14 = r23.j;
        if (r14 == null) goto L33;
        boolean r15 = r14.booleanValue();
    L34:
        setCoverEdited(r15);
        String r16 = r23.k;
        if (r16 != null) goto L37;
        r16 = "";
    L37:
        setCoverMainColor(r16);
        Boolean r17 = r23.l;
        if (r17 == null) goto L40;
        boolean r18 = r17.booleanValue();
    L41:
        setMusicGenFailed(r18);
        String r19 = r23.m;
        if (r19 != null) goto L44;
        r19 = "";
    L44:
        setMusicGenFailedMsg(r19);
        String r20 = r23.n;
        if (r20 != null) goto L47;
        r20 = "";
    L47:
        setChunkUrl(r20);
        Integer r21 = r23.o;
        if (r21 == null) goto L50;
        int r22 = r21.intValue();
    L51:
        setMusicGenType(r22);
        String r24 = r23.p;
        if (r24 != null) goto L54;
        r24 = "";
    L54:
        setUseTemplateId(r24);
        String r25 = r23.q;
        if (r25 != null) goto L57;
        r25 = "";
    L57:
        setUniqueTaskId(r25);
        Boolean r26 = r23.r;
        if (r26 == null) goto L60;
        r11 = r26.booleanValue();
    L60:
        setBlock(r11);
        Long r27 = r23.s;
        long r28 = 0;
        if (r27 == null) goto L63;
        long r29 = r27.longValue();
    L64:
        this.a = r29;
        String r30 = r23.t;
        if (r30 == null) goto L68;
        r3 = r30;
    L68:
        this.b = r3;
        Long r31 = r23.u;
        if (r31 == null) goto L71;
        r28 = r31.longValue();
    L71:
        this.c = r28;
        this.d = r23.v;
        setContentType(1);
        return;
    L63:
        r29 = 0;
        goto L64
    L50:
        r22 = 0;
        goto L51
    L40:
        r18 = false;
        goto L41
    L33:
        r15 = false;
        goto L34
    L26:
        r12 = false;
        goto L27
    }
}
