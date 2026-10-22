package com.obric.aikernel.middleware.impl.settings;

import com.bytedance.apm6.fd.config.FdConfig;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s7.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements s7.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4595g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final j[] f4596h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("quota_dur_in_sec")
    private final int f4597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("enable_default_quote")
    private final boolean f4598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("enable_power_restrict")
    private final boolean f4599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("foreground_model_cpu_whitelist")
    private final String[] f4600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d6.c("model_scene_cpu_whitelist")
    private final j[] f4601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d6.c(alternate = {"default_model_quota_v2"}, value = "default_model_quota_v3")
    private final j[] f4602f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ j[] a(a r10) {
            return r10.b();
        }

        private final j[] b() {
            return c.g();
        }
    }

    static {
        f4595g = new a(null);
        f4596h = new j[]{new j("_default", null, 1000, FdConfig.DEFAULT_FD_COUNT_THRESHOLD, 0, "300", 16, null), new j("memory_text_embedding_v2", null, 3000, 2500, 0, "300", 16, null), new j("vlm_local", "embedding", 600, 500, -1, "300"), new j("vlm_local", "notification_rank", 10, 8, -1, "60"), new j("vlm_local", null, 80, 60, -1, "300")};
    }

    public c() {
        this.f4597a = 60;
        this.f4598b = true;
        this.f4600d = new String[]{"vlm_local", "ocr_service", "bert_all_in_one", "clip_image_embedding_v2_edge", "album_slot_extraction", "segmentation", "video_clip"};
        this.f4601e = new j[]{new j("vlm_local", "caption", 0, 0, 0, null, 48, null), new j("vlm_local", "tag", 0, 0, 0, null, 48, null), new j("vlm_local", "memory_vlm_ondevice", 0, 0, 0, null, 48, null)};
        this.f4602f = a.a(f4595g);
    }

    public static final /* synthetic */ j[] g() {
        return f4596h;
    }

    private final j i(j[] r10, String r11, String r12, int r13) {
        int r14 = r10.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        j r17 = null;
        if (r16 >= r14) goto L16;
        j r18 = r10[r16];
        if (Intrinsics.areEqual(r18.c(), r11) == true) goto L8;
    L12:
        boolean r19 = false;
    L13:
        if (r19 == true) goto L17;
        r16 = r16 + 1;
    L17:
        if (r18 != null) goto L89;
        int r20 = r10.length;
        int r21 = 0;
    L20:
        if (r21 >= r20) goto L32;
        j r22 = r10[r21];
        if (Intrinsics.areEqual(r22.c(), r11) == true) goto L24;
    L28:
        boolean r23 = false;
    L29:
        if (r23 == true) goto L33;
        r21 = r21 + 1;
    L33:
        if (r22 != null) goto L78;
        int r24 = r10.length;
        int r110 = 0;
    L36:
        if (r110 >= r24) goto L50;
        r22 = r10[r110];
        if (Intrinsics.areEqual(r22.c(), r11) == true) goto L40;
    L46:
        boolean r25 = false;
    L47:
        if (r25 == true) goto L51;
        r110 = r110 + 1;
    L51:
        if (r22 != null) goto L78;
        int r26 = r10.length;
        int r111 = 0;
    L53:
        if (r111 >= r26) goto L67;
        j r112 = r10[r111];
        if (Intrinsics.areEqual(r112.c(), r11) == true) goto L57;
    L63:
        boolean r27 = false;
    L64:
        if (r27 == true) goto L65;
        r111 = r111 + 1;
        goto L53
    L65:
        r17 = r112;
        goto L67
    L57:
        if (r112.d() != (-1)) goto L63;
        if (Intrinsics.areEqual(r112.e(), "") == false) goto L61;
    L62:
        r27 = true;
        goto L64
    L61:
        if (r112.e() != null) goto L63;
    L67:
        if (r17 != null) goto L90;
        int r28 = r10.length;
    L69:
        if (r15 >= r28) goto L75;
        j r29 = r10[r15];
        if (Intrinsics.areEqual(r29.c(), "_default") == true) goto L91;
        r15 = r15 + 1;
        goto L69
    L91:
        return r29;
    L75:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L90:
        return r17;
    L40:
        if (r22.d() != r13) goto L46;
        if (Intrinsics.areEqual(r22.e(), "") == false) goto L44;
    L45:
        r25 = true;
        goto L47
    L44:
        if (r22.e() != null) goto L46;
    L50:
        r22 = null;
    L78:
        return r22;
    L24:
        if (r22.d() != (-1)) goto L28;
        if (Intrinsics.areEqual(r22.e(), r12) == false) goto L28;
        r23 = true;
        goto L29
    L32:
        r22 = null;
        goto L33
    L89:
        return r18;
    L8:
        if (Intrinsics.areEqual(r18.e(), r12) == false) goto L12;
        if (r18.d() != r13) goto L12;
        r19 = true;
        goto L13
    L16:
        r18 = null;
        goto L17
    }

    private final j k(j r10, j r11) {
        String r12 = r10.f();
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
    L37:
        return r10;
    L11:
        if (Intrinsics.areEqual(r10.c(), "_default") == true) goto L37;
        if (Intrinsics.areEqual(r11.c(), "_default") == true) goto L37;
        if (Intrinsics.areEqual(r11.c(), r10.c()) == false) goto L37;
        String r14 = r11.e();
        String r15 = "";
        if (r14 != null) goto L20;
        r14 = "";
    L20:
        String r16 = r10.e();
        if (r16 == null) goto L25;
        r15 = r16;
    L25:
        if (Intrinsics.areEqual(r14, r15) == false) goto L37;
        String r17 = r11.f();
        if (r17 == null) goto L37;
        if ((!StringsKt.isBlank(r17)) == true) goto L33;
        r17 = null;
    L33:
        String r18 = r17;
        if (r18 == null) goto L37;
        return j.b(r10, null, null, 0, 0, 0, r18, 31, null);
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r13 = false;
        goto L9
    }

    @Override // s7.d
    public j[] a() {
        return this.f4601e;
    }

    @Override // s7.d
    public boolean b() {
        return this.f4599c;
    }

    @Override // s7.d
    public String[] c() {
        return this.f4600d;
    }

    @Override // s7.d
    public j d(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        j r13 = i(a.a(f4595g), r10, r11, r12);
        return k(i(j(), r10, r11, r12), r13);
    }

    @Override // s7.d
    public int e() {
        return this.f4597a;
    }

    @Override // s7.d
    public boolean f() {
        return this.f4598b;
    }

    public c h() {
        return new c();
    }

    public j[] j() {
        return this.f4602f;
    }
}
