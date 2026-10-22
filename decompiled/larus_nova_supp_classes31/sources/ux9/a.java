package ux9;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.trace.CopyContentTypeString;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent$Result;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent$Stage;
import com.larus.utils.logger.FLogger;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final C0081a i = null;
    public static final LinkedHashMap<String, a> j = null;
    public final Map<String, Object> a;
    public final Function0<String> b;
    public final long c;
    public int d;
    public int e;
    public c f;
    public Long g;
    public String h;

    /* JADX INFO: renamed from: ux9.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public C0081a() {
        }

        public final synchronized a c(String r2) {
            monitor-enter(this);
            a r3 = a.j.get(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized List<b> d(List<String> r7) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r7, "localMessageIds");     // Catch: Throwable -> L22
            String r0 = UUID.randomUUID().toString();     // Catch: Throwable -> L22
            List r8 = CollectionsKt.filterNotNull(r7);     // Catch: Throwable -> L22
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L22
            Iterator r9 = r8.iterator();     // Catch: Throwable -> L22
        L5:
            if (r9.hasNext() == false) goto L9;
            Object r2 = r9.next();     // Catch: Throwable -> L22
            if ((!StringsKt.isBlank((String) r2)) == false) goto L5;
            r1.add(r2);     // Catch: Throwable -> L22
            goto L5
        L9:
            List r10 = CollectionsKt.distinct(r1);     // Catch: Throwable -> L22
            ArrayList r3 = new ArrayList();     // Catch: Throwable -> L22
            Iterator r11 = r10.iterator();     // Catch: Throwable -> L22
        L10:
            if (r11.hasNext() == false) goto L20;
            String r4 = (String) r11.next();     // Catch: Throwable -> L22
            Collection<a> r5 = a.j.values();     // Catch: Throwable -> L22
            ArrayList r6 = new ArrayList();     // Catch: Throwable -> L22
            Iterator<T> r12 = r5.iterator();     // Catch: Throwable -> L22
        L14:
            if (r12.hasNext() == false) goto L18;
            b r13 = a.a((a) r12.next(), r4, r0);     // Catch: Throwable -> L22
            if (r13 == null) goto L14;
            r6.add(r13);     // Catch: Throwable -> L22
            goto L14
        L18:
            CollectionsKt.addAll(r3, r6);     // Catch: Throwable -> L22
            goto L10
        L20:
            monitor-exit(this);
            return r3;
        L22:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(List<String> r7, String r8) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r7, "fileIdentifiers");     // Catch: Throwable -> L42
            if (r8 != null) goto L6;
        L9:
            boolean r1 = true;
        L10:
            if (r1 == false) goto L13;
            monitor-exit(this);
            return;
        L13:
            LinkedHashMap<String, a> r2 = a.j;     // Catch: Throwable -> L42
            LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L42
            Iterator<Map.Entry<String, a>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L42
        L15:
            if (r4.hasNext() == false) goto L19;
            Map.Entry<String, a> r5 = r4.next();     // Catch: Throwable -> L42
            if ((!((ArrayList) r7).contains(r5.getKey())) == false) goto L15;
            r3.put(r5.getKey(), r5.getValue());     // Catch: Throwable -> L42
            goto L15
        L19:
            Iterator r0 = r3.values().iterator();     // Catch: Throwable -> L42
        L21:
            if (r0.hasNext() == false) goto L33;
            a r6 = (a) r0.next();     // Catch: Throwable -> L42
            monitor-enter(r6);     // Catch: Throwable -> L42
            if (Intrinsics.areEqual(r6.h, r8) == false) goto L27;
            r6.h = null;     // Catch: Throwable -> L30
        L27:
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L30
            monitor-exit(r6);     // Catch: Throwable -> L42
            goto L21
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L33:
            Iterator<T> r10 = r7.iterator();     // Catch: Throwable -> L42
        L35:
            if (r10.hasNext() == false) goto L40;
            a r11 = a.i.c((String) r10.next());     // Catch: Throwable -> L42
            if (r11 == null) goto L35;
            r11.d(r8, Integer.valueOf(((ArrayList) r7).size()));     // Catch: Throwable -> L42
            goto L35
        L40:
            monitor-exit(this);
            return;
        L6:
            if (StringsKt.isBlank(r8) == true) goto L9;
            r1 = false;
        L42:
            th = move-exception;
            throw th;
        }

        public static void b(Map r2, AudioAttachmentUploadEvent$Result r3, String r4, String r5) {
            JSONObject r0 = new JSONObject(r2);     // Catch: Exception -> L19
            r0.put("event_version", 1);     // Catch: Exception -> L19
            r0.put("phase", r3.getStage().getPhase());     // Catch: Exception -> L19
            r0.put("stage", r3.getStage().getValue());     // Catch: Exception -> L19
            r0.put(CopyContentTypeString.CODE, r3.getCode());     // Catch: Exception -> L19
            r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r3.getReason());     // Catch: Exception -> L19
            if (r4 != null) goto L5;
        L10:
            if (r5 != null) goto L12;
        L17:
            by7.a r6 = new by7.a("flow_doc_audio_attachment_upload_status");     // Catch: Exception -> L19
            r6.a.merge(new TrackParams().merge(r0));     // Catch: Exception -> L19
            r6.b();     // Catch: Exception -> L19
            return;
        L12:
            if (new Regex("[a-zA-Z0-9_.:-]{1,120}").matches(r5) == true) goto L15;
            r5 = null;
        L15:
            if (r5 == null) goto L17;
            r0.put("sub_reason", r5);     // Catch: Exception -> L19
            goto L17
        L5:
            if (new Regex("[a-zA-Z0-9_.:-]{1,80}").matches(r4) == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L10;
            r0.put("sub_code", r4);     // Catch: Exception -> L19
        L19:
            e = move-exception;
            FLogger.a.w("AudioAttachmentUploadTracker", "emit failed: ".concat(e.getClass().getSimpleName()));
        }

        public final synchronized a e(String r6, String r7, String r8, int r9, String r10, String r11, String r12, boolean r13, Function0<String> r14) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r6, "fileIdentifier");     // Catch: Throwable -> L27
            Intrinsics.checkNotNullParameter(r10, "uploadFrom");     // Catch: Throwable -> L27
            Pair[] r0 = new Pair[8];     // Catch: Throwable -> L27
            Pair r1 = TuplesKt.to("attachment_id", UUID.randomUUID().toString());     // Catch: Throwable -> L27
            int r2 = 0;
            r0[0] = r1;     // Catch: Throwable -> L27
            if (r7 != null) goto L6;
            r7 = "";
        L6:
            r0[1] = TuplesKt.to("conversation_id", r7);     // Catch: Throwable -> L27
            if (r8 != null) goto L9;
            r8 = "";
        L9:
            r0[2] = TuplesKt.to("bot_id", r8);     // Catch: Throwable -> L27
            r0[3] = TuplesKt.to("upload_from", r10);     // Catch: Throwable -> L27
            r0[4] = TuplesKt.to("audio_duration_ms", -1L);     // Catch: Throwable -> L27
            if (r13 == false) goto L12;
            int r15 = 1;
        L13:
            r0[5] = TuplesKt.to("audio_parse_type", Integer.valueOf(r15));     // Catch: Throwable -> L27
            r0[6] = TuplesKt.to("attachment_count", Integer.valueOf(r9));     // Catch: Throwable -> L27
            if (r9 <= 1) goto L16;
            r2 = 1;
        L16:
            r0[7] = TuplesKt.to("is_multi_file", Integer.valueOf(r2));     // Catch: Throwable -> L27
            Map r16 = MapsKt.mutableMapOf(r0);     // Catch: Throwable -> L27
            if (r11 == null) goto L19;
            r16.put("upload_way", r11);     // Catch: Throwable -> L27
        L19:
            if (r12 == null) goto L21;
            r16.put("enter_method", r12);     // Catch: Throwable -> L27
        L21:
            a r17 = new a(r16, r14);     // Catch: Throwable -> L27
            LinkedHashMap<String, a> r18 = a.j;     // Catch: Throwable -> L27
            r18.put(r6, r17);     // Catch: Throwable -> L27
            if (r18.size() <= 512) goto L24;
            r18.remove(CollectionsKt.first(r18.keySet()));     // Catch: Throwable -> L27
        L24:
            c.e(r17.f, AudioAttachmentUploadEvent$Result.SELECTED, null, null, 6);     // Catch: Throwable -> L27
            r16.remove("audio_parse_type");     // Catch: Throwable -> L27
            monitor-exit(this);
            return r17;
        L12:
            r15 = 0;
        L27:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {
        public final Map<String, Object> a;
        public final int b;
        public final String c;
        public final long d;
        public final Function0<String> e;
        public final long f;
        public Long g;
        public boolean h;

        public final synchronized void a() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.h == false) goto L6;
        L11:
            monitor-exit(this);
            return;
        L6:
            if (this.g != null) goto L11;
            this.g = Long.valueOf(SystemClock.elapsedRealtime());     // Catch: Throwable -> L13
            C0081a r0 = a.i;     // Catch: Throwable -> L13
            C0081a.b(d(), AudioAttachmentUploadEvent$Result.SEND_DISPATCHED, null, null);     // Catch: Throwable -> L13
            monitor-exit(this);
        }

        public final Map<String, Object> d() {
            Map<String, Object> r0 = MapsKt.toMutableMap(this.a);
            Function0<String> r1 = this.e;
            if (r1 != null) goto L20;
        L14:
            r0.put("send_attempt_id", this.c);
            r0.put("send_attempt_index", Integer.valueOf(this.b));
            long r2 = SystemClock.elapsedRealtime();
            Long r3 = this.g;
            if (r3 == null) goto L17;
            long r4 = r3.longValue();
        L18:
            r0.put("stage_duration_ms", Long.valueOf(r2 - r4));
            return r0;
        L17:
            r4 = this.f;
            goto L18
        L20:
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
            Object r6 = Result.constructor-impl(r1.invoke());     // Catch: Throwable -> L6
        L9:
            if (Result.isFailure-impl(r6) == false) goto L11;
            r6 = null;
        L11:
            String r7 = (String) r6;
            if (r7 == null) goto L14;
            r0.put("app_state", r7);
        L6:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }

        public final void b(int r9, Throwable r10) {
            if ((r10 instanceof SocketTimeoutException) == false) goto L7;
            AudioAttachmentUploadEvent$Result r0 = AudioAttachmentUploadEvent$Result.SEND_TIMEOUT;
        L5:
            AudioAttachmentUploadEvent$Result r2 = r0;
            String r4 = String.valueOf(r9);
            if (r10 == null) goto L25;
            String r11 = r10.getClass().getSimpleName();
        L26:
            c(this, r2, null, r4, r11, null, 18);
            return;
        L25:
            r11 = null;
            goto L26
        L7:
            if (r9 != (-103)) goto L10;
            r0 = AudioAttachmentUploadEvent$Result.ENCODE_FAILED;
            goto L5
        L10:
            if (r9 != (-12)) goto L12;
        L21:
            r0 = AudioAttachmentUploadEvent$Result.LOCAL_MESSAGE_MISSING;
            goto L5
        L12:
            if (r9 == (-16)) goto L21;
            if (r9 != (-101)) goto L18;
            r0 = AudioAttachmentUploadEvent$Result.CONNECTION_UNAVAILABLE;
            goto L5
        L18:
            if (SetsKt.setOf(new Integer[]{712013109, 712014004, 712013104, 712013003}).contains(Integer.valueOf(r9)) == false) goto L20;
            r0 = AudioAttachmentUploadEvent$Result.BUSINESS_REJECTED;
            goto L5
        L20:
            r0 = AudioAttachmentUploadEvent$Result.IM_SDK_FAILED;
            goto L5
        }

        public b(Map<String, ? extends Object> r2, int r3, String r4, long r5, Function0<String> r7) {
            Intrinsics.checkNotNullParameter(r2, "fields");
            Intrinsics.checkNotNullParameter(r4, "id");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = SystemClock.elapsedRealtime();
        }

        public static void c(b r4, AudioAttachmentUploadEvent$Result r5, String r6, String r7, String r8, String r9, int r10) {
            String r1 = null;
            if ((r10 & 2) == 0) goto L6;
            r6 = null;
        L6:
            if ((r10 & 4) == 0) goto L9;
            r7 = null;
        L9:
            if ((r10 & 8) == 0) goto L12;
            r8 = null;
        L12:
            if ((r10 & 16) == 0) goto L14;
            r9 = null;
        L14:
            monitor-enter(r4);
            Intrinsics.checkNotNullParameter(r5, "result");     // Catch: Throwable -> L51
            if (r9 == null) goto L22;
            if (Intrinsics.areEqual(r4.a.get("local_message_id"), r9) == true) goto L22;
            monitor-exit(r4);
            return;
        L22:
            if (r4.h == false) goto L24;
        L49:
            monitor-exit(r4);
            return;
        L24:
            if (r5.getStage() != AudioAttachmentUploadEvent$Stage.SENT) goto L49;
            r4.h = true;     // Catch: Throwable -> L51
            if (r5 != AudioAttachmentUploadEvent$Result.SENT) goto L36;
            if (r6 != null) goto L30;
        L33:
            boolean r11 = true;
        L34:
            if (r11 == false) goto L36;
            r5 = AudioAttachmentUploadEvent$Result.SEND_UNKNOWN;     // Catch: Throwable -> L51
            goto L36
        L30:
            if (StringsKt.isBlank(r6) == true) goto L33;
            r11 = false;
        L36:
            Map<String, Object> r12 = r4.d();     // Catch: Throwable -> L51
            if (r6 != null) goto L39;
        L43:
            r12.put("ready_to_send_elapsed_ms", Long.valueOf(SystemClock.elapsedRealtime() - r4.d));     // Catch: Throwable -> L51
            Long r13 = r4.g;     // Catch: Throwable -> L51
            if (r13 == null) goto L46;
            r12.put("send_duration_ms", Long.valueOf(SystemClock.elapsedRealtime() - r13.longValue()));     // Catch: Throwable -> L51
        L46:
            C0081a r14 = a.i;     // Catch: Throwable -> L51
            C0081a.b(r12, r5, r7, r8);     // Catch: Throwable -> L51
            monitor-exit(r4);
            return;
        L39:
            if ((true ^ StringsKt.isBlank(r6)) == false) goto L41;
            r1 = r6;
        L41:
            if (r1 == null) goto L43;
            r12.put("message_id", r1);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            throw th;
        }
    }

    public static final class c {
        public final a a;
        public final String b;
        public final int c;
        public final Set<AudioAttachmentUploadEvent$Stage> d;
        public long e;
        public Long f;
        public Long g;
        public Long h;
        public Long i;
        public Long j;
        public String k;
        public volatile boolean l;
        public volatile boolean m;

        /* JADX INFO: renamed from: ux9.a$c$a, reason: collision with other inner class name */
        public /* synthetic */ class C0082a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[AudioAttachmentUploadEvent$Result.values().length];
                r0[AudioAttachmentUploadEvent$Result.FAST_UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[AudioAttachmentUploadEvent$Result.ARTIFACT_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[AudioAttachmentUploadEvent$Result.DRIVE_REUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[AudioAttachmentUploadEvent$Result.HISTORY_REUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public final synchronized void c() {
            monitor-enter(this);
            Long r0 = this.i;     // Catch: Throwable -> L13
            if (r0 == null) goto L10;
            long r1 = r0.longValue();     // Catch: Throwable -> L13
            Long r2 = this.j;     // Catch: Throwable -> L13
            if (r2 == null) goto L8;
            long r3 = r2.longValue();     // Catch: Throwable -> L13
        L9:
            this.j = Long.valueOf((r3 + SystemClock.elapsedRealtime()) - r1);     // Catch: Throwable -> L13
            goto L10
        L8:
            r3 = 0;
        L10:
            this.i = null;     // Catch: Throwable -> L13
            monitor-exit(this);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public final synchronized void d() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.i != null) goto L6;
            this.i = Long.valueOf(SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        public final synchronized void f() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.h != null) goto L10;
            Long r0 = this.g;     // Catch: Throwable -> L12
            if (r0 == null) goto L8;
            long r1 = r0.longValue();     // Catch: Throwable -> L12
            Long r2 = Long.valueOf(SystemClock.elapsedRealtime() - r1);     // Catch: Throwable -> L12
        L9:
            this.h = r2;     // Catch: Throwable -> L12
            goto L10
        L8:
            r2 = null;
        L10:
            monitor-exit(this);
        }

        public final synchronized void a(AudioAttachmentUploadEvent$Result r3) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r3, "result");     // Catch: Throwable -> L26
            if (this.m == false) goto L6;
        L24:
            monitor-exit(this);
            return;
        L6:
            if (r3.getStage() != AudioAttachmentUploadEvent$Stage.PATH) goto L24;
            int r0 = C0082a.a[r3.ordinal()];     // Catch: Throwable -> L26
            if (r0 != 1) goto L11;
            String r1 = "fast_upload";
        L21:
            this.k = r1;     // Catch: Throwable -> L26
            e(this, r3, null, null, 6);     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L11:
            if (r0 != 2) goto L13;
            r1 = "artifact_cache";
            goto L21
        L13:
            if (r0 != 3) goto L15;
            r1 = "drive_reuse";
            goto L21
        L15:
            if (r0 == 4) goto L17;
            r1 = "full_upload";
            goto L21
        L17:
            r1 = "history_reuse";
        L26:
            th = move-exception;
            throw th;
        }

        public c(a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "owner");
            this.a = r2;
            this.b = UUID.randomUUID().toString();
            this.c = r3;
            this.d = new LinkedHashSet();
            this.e = SystemClock.elapsedRealtime();
        }

        public final synchronized void b(String r9, String r10, boolean r11) {
            monitor-enter(this);
        L61:
            th = move-exception;
            throw th;
        L4:
            if (this.m == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            boolean r0 = false;
            if (r9 != null) goto L10;
        L13:
            boolean r2 = true;
        L15:
            if (r2 == false) goto L17;
        L58:
            e(this, AudioAttachmentUploadEvent$Result.ARTIFACT_MISSING, null, null, 6);     // Catch: Throwable -> L61
            monitor-exit(this);
            return;
        L17:
            if (StringsKt.startsWith$default(r9, "/", false, 2, null) == true) goto L58;
            if (StringsKt.startsWith$default(r9, "file:", false, 2, null) == true) goto L58;
            if (StringsKt.startsWith$default(r9, "content:", false, 2, null) == true) goto L58;
            if (r11 == false) goto L32;
            if (r10 != null) goto L26;
        L27:
            r0 = true;
        L28:
            if (r0 == false) goto L32;
            e(this, AudioAttachmentUploadEvent$Result.REGISTER_FAILED, null, null, 6);     // Catch: Throwable -> L61
            monitor-exit(this);
            return;
        L26:
            if (StringsKt.isBlank(r10) == false) goto L28;
        L32:
            long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L61
            a r1 = this.a;     // Catch: Throwable -> L61
            C0081a r5 = a.i;     // Catch: Throwable -> L61
            Map r4 = MapsKt.toMutableMap(r1.h());     // Catch: Throwable -> L61
            r4.put("upload_attempt_id", this.b);     // Catch: Throwable -> L61
            r4.put("upload_attempt_index", Integer.valueOf(this.c));     // Catch: Throwable -> L61
            r4.put("uri", r9);     // Catch: Throwable -> L61
            if (r10 == null) goto L35;
            r4.put("resource_id", r10);     // Catch: Throwable -> L61
        L35:
            r4.put("resource_center_enabled", Integer.valueOf(r11 ? 1 : 0));     // Catch: Throwable -> L61
            r4.put("resource_elapsed_ms", Long.valueOf(r3 - this.a.c));     // Catch: Throwable -> L61
            Long r12 = this.f;     // Catch: Throwable -> L61
            if (r12 == null) goto L38;
            long r6 = r12.longValue();     // Catch: Throwable -> L61
        L39:
            r4.put("stage_duration_ms", Long.valueOf(r3 - r6));     // Catch: Throwable -> L61
            String r13 = this.k;     // Catch: Throwable -> L61
            if (r13 == null) goto L43;
            r4.put("upload_mode", r13);     // Catch: Throwable -> L61
        L43:
            if (CollectionsKt.contains(SetsKt.setOf(new String[]{"fast_upload", "artifact_cache", "drive_reuse", "history_reuse"}), this.k) == false) goto L45;
            Long r14 = 0L;     // Catch: Throwable -> L61
        L46:
            if (r14 == null) goto L48;
            r4.put("upload_duration_ms", Long.valueOf(r14.longValue()));     // Catch: Throwable -> L61
        L48:
            Long r15 = this.j;     // Catch: Throwable -> L61
            if (r15 != null) goto L53;
            if (r11 == true) goto L52;
            r15 = 0L;     // Catch: Throwable -> L61
            goto L53
        L52:
            r15 = null;
        L53:
            if (r15 == null) goto L55;
            r4.put("register_duration_ms", Long.valueOf(r15.longValue()));     // Catch: Throwable -> L61
        L55:
            this.m = true;     // Catch: Throwable -> L61
            a.b(this.a, this, r3);     // Catch: Throwable -> L61
            C0081a.b(r4, AudioAttachmentUploadEvent$Result.READY, null, null);     // Catch: Throwable -> L61
            monitor-exit(this);
            return;
        L45:
            r14 = this.h;     // Catch: Throwable -> L61
            goto L46
        L38:
            r6 = this.e;     // Catch: Throwable -> L61
            goto L39
        L10:
            if (StringsKt.isBlank(r9) == true) goto L13;
            r2 = false;
            goto L15
        }

        public static void e(c r8, AudioAttachmentUploadEvent$Result r9, String r10, String r11, int r12) {
            if ((r12 & 2) == 0) goto L6;
            r10 = null;
        L6:
            if ((r12 & 4) == 0) goto L8;
            r11 = null;
        L8:
            monitor-enter(r8);
            Intrinsics.checkNotNullParameter(r9, "result");     // Catch: Throwable -> L38
            if (r8.m == false) goto L12;
        L36:
            monitor-exit(r8);
            return;
        L12:
            if (Intrinsics.areEqual(r9.getStage().getPhase(), "resource") == false) goto L36;
            if (r8.d.add(r9.getStage()) == false) goto L36;
            long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
            if (r9 != AudioAttachmentUploadEvent$Result.UPLOAD_DISPATCHED) goto L19;
            r8.l = true;     // Catch: Throwable -> L38
            r8.f = Long.valueOf(r0);     // Catch: Throwable -> L38
        L19:
            a r13 = r8.a;     // Catch: Throwable -> L38
            C0081a r3 = a.i;     // Catch: Throwable -> L38
            Map r14 = MapsKt.toMutableMap(r13.h());     // Catch: Throwable -> L38
            r14.put("upload_attempt_id", r8.b);     // Catch: Throwable -> L38
            r14.put("upload_attempt_index", Integer.valueOf(r8.c));     // Catch: Throwable -> L38
            r14.put("resource_elapsed_ms", Long.valueOf(r0 - r8.a.c));     // Catch: Throwable -> L38
            AudioAttachmentUploadEvent$Stage r4 = r9.getStage();     // Catch: Throwable -> L38
            AudioAttachmentUploadEvent$Stage r5 = AudioAttachmentUploadEvent$Stage.READY;     // Catch: Throwable -> L38
            if (r4 != r5) goto L24;
            Long r6 = r8.f;     // Catch: Throwable -> L38
            if (r6 == null) goto L24;
            long r7 = r6.longValue();     // Catch: Throwable -> L38
        L25:
            r14.put("stage_duration_ms", Long.valueOf(r0 - r7));     // Catch: Throwable -> L38
            String r15 = r8.k;     // Catch: Throwable -> L38
            if (r15 == null) goto L29;
            r14.put("upload_mode", r15);     // Catch: Throwable -> L38
        L29:
            if (r9.getCode() == 0) goto L31;
        L32:
            r8.m = true;     // Catch: Throwable -> L38
        L33:
            C0081a r2 = a.i;     // Catch: Throwable -> L38
            C0081a.b(r14, r9, r10, r11);     // Catch: Throwable -> L38
            r8.e = r0;     // Catch: Throwable -> L38
            monitor-exit(r8);
            return;
        L31:
            if (r9.getStage() != r5) goto L33;
        L24:
            r7 = r8.e;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        }
    }

    public a() {
        throw null;
    }

    public final synchronized c c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f.l == false) goto L6;
    L7:
        int r1 = this.d + 1;     // Catch: Throwable -> L11
        this.d = r1;     // Catch: Throwable -> L11
        this.f = new c(this, r1);     // Catch: Throwable -> L11
        this.g = null;     // Catch: Throwable -> L11
    L8:
        c r0 = this.f;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        if (this.f.m == false) goto L8;
        goto L7
    }

    public final synchronized c e() {
        monitor-enter(this);
        c r0 = this.f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Map<String, Object> h() {
        monitor-enter(this);
        Map<String, Object> r0 = MapsKt.toMutableMap(this.a);     // Catch: Throwable -> L17
        Function0<String> r1 = this.b;     // Catch: Throwable -> L17
        if (r1 != null) goto L22;
    L15:
        monitor-exit(this);
        return r0;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(r1.invoke());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        String r4 = (String) r3;     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        r0.put("app_state", r4);     // Catch: Throwable -> L17
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    static {
        i = new C0081a();
        j = new LinkedHashMap();
    }

    public a(Map r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
        this.c = SystemClock.elapsedRealtime();
        this.d = 1;
        this.f = new c(this, 1);
    }

    public final synchronized void d(String r5, Integer r6) {
        monitor-enter(this);
        int r0 = 0;
        if (r5 != null) goto L24;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        this.h = r5;     // Catch: Throwable -> L9
        this.a.put("local_message_id", r5);     // Catch: Throwable -> L9
    L14:
        if (r6 == null) goto L22;
        int r7 = r6.intValue();     // Catch: Throwable -> L9
        Integer r8 = Integer.valueOf(r7);     // Catch: Throwable -> L9
        this.a.put("attachment_count", r8);     // Catch: Throwable -> L9
        Map<String, Object> r9 = this.a;     // Catch: Throwable -> L9
        if (r7 <= 1) goto L18;
        r0 = 1;
    L18:
        r9.put("is_multi_file", Integer.valueOf(r0));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L22:
        monitor-exit(this);
        return;
    L24:
        if (StringsKt.isBlank(r5) == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final b a(a r8, String r9, String r10) {
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L4:
        b r0 = null;
        if (Intrinsics.areEqual(r8.h, r9) == true) goto L8;
        monitor-exit(r8);
    L14:
        return r0;
    L8:
        Long r11 = r8.g;     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        long r5 = r11.longValue();     // Catch: Throwable -> L15
        Map<String, Object> r2 = r8.h();     // Catch: Throwable -> L15
        int r3 = r8.e + 1;     // Catch: Throwable -> L15
        r8.e = r3;     // Catch: Throwable -> L15
        r0 = new b(r2, r3, r10, r5, r8.b);     // Catch: Throwable -> L15
        monitor-exit(r8);
        goto L14
    L13:
        monitor-exit(r8);
        goto L14
    }

    public static final void b(a r1, c r2, long r3) {
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r2 != r1.f) goto L6;
        r1.g = Long.valueOf(r3);     // Catch: Throwable -> L8
    L6:
        monitor-exit(r1);
    }

    public static /* synthetic */ void g(a r1, String r2, Long r3) {
        r1.f(r2, r3, null);
    }

    public final synchronized void f(String r5, Long r6, Long r7) {
        monitor-enter(this);
        if (r5 != null) goto L27;
    L14:
        if (r6 == null) goto L16;
        Long r8 = Long.valueOf(r6.longValue());     // Catch: Throwable -> L12
        this.a.put("file_size_bytes", r8);     // Catch: Throwable -> L12
    L16:
        if (r7 == null) goto L25;
        long r9 = r7.longValue();     // Catch: Throwable -> L12
        Map<String, Object> r10 = this.a;     // Catch: Throwable -> L12
        if (r9 > 0) goto L21;
        r9 = -1;
    L21:
        r10.put("audio_duration_ms", Long.valueOf(r9));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L25:
        monitor-exit(this);
        return;
    L27:
        String r11 = r5.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L12
        if (r11 == null) goto L14;
        if (new Regex("[a-z0-9]{1,16}").matches(r11) == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L14;
        this.a.put("file_extension", r11);     // Catch: Throwable -> L12
        goto L14
    }
}
