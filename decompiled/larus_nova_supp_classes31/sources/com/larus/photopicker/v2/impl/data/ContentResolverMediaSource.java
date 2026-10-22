package com.larus.photopicker.v2.impl.data;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kq9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ContentResolverMediaSource implements e {
    public final Context a;
    public final LazyLoadConfig b;
    public final String c;
    public final Lazy d;

    public ContentResolverMediaSource(Context r2, LazyLoadConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lazyLoadConfig");
        this.a = r2;
        this.b = r3;
        this.c = "ContentResolverMediaSource";
        this.d = LazyKt.lazy(new a());
    }

    @Override // com.larus.photopicker.v2.impl.data.e
    public final Object a(String r4, Continuation<? super mp9.c> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContentResolverMediaSource$queryMediaItem$2(r4, this, null), r5);
    }

    @Override // com.larus.photopicker.v2.impl.data.e
    public final Object b(List<? extends MediaTab> r4, mp9.a r5, Continuation<? super List<mp9.b>> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContentResolverMediaSource$loadMediaFolders$2(this, r5, r4, null), r6);
    }

    public static Object e(Object r1, Map r2, String r3, Object r4) {
        if (r1 != null) goto L8;
        Integer r0 = (Integer) ((LinkedHashMap) r2).get(r3);
        if (r0 == null) goto L6;
        int r5 = r0.intValue();
    L7:
        r2.put(r3, Integer.valueOf(r5 + 1));
        goto L8
    L6:
        r5 = 0;
    L8:
        if (r1 == null) goto L10;
        return r1;
    L10:
        return r4;
    }

    @Override // com.larus.photopicker.v2.impl.data.e
    public final Object c(int r9, int r10, mp9.a r11, Continuation<? super List<mp9.c>> r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContentResolverMediaSource$loadMediaItems$2(r11, this, r9, r10, null), r12);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static final void d(ContentResolverMediaSource r57, Cursor r58, List r59, int r60, int r61) {
        int r2 = r61;
        r57.getClass();
        String r4 = "height";
        String r5 = "width";
        String r6 = "";
        if (r58 == null) goto L321;
        Cursor r7 = r58;     // Catch: Exception -> L250
        Cursor r8 = r7;     // Catch: Throwable -> L241
        int r9 = r8.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L241
        int r10 = r8.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L241
        int r11 = r8.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L241
        int r12 = r8.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L241
        int r13 = r8.getColumnIndexOrThrow("width");     // Catch: Throwable -> L241
        int r14 = r8.getColumnIndexOrThrow("height");     // Catch: Throwable -> L241
        int r15 = r8.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L241
        int r16 = c.c;     // Catch: Throwable -> L241
        int r17 = r8.getColumnIndexOrThrow("bucket_id");     // Catch: Throwable -> L237
        String r18 = "image/";
        int r3 = r8.getColumnIndexOrThrow("bucket_display_name");     // Catch: Throwable -> L237
        int r19 = r8.getColumnIndexOrThrow("duration");     // Catch: Throwable -> L237
        if (r60 != (-1)) goto L17;
        boolean r20 = true;
    L18:
        if (r20 == false) goto L268;
    L24:
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L237
        ContentResolverMediaSource r22 = r57;
        int r21 = r11;
        int r110 = 0;
    L26:
        if (r20 == true) goto L298;
        if (r110 < r2) goto L298;
    L29:
        LinkedHashMap r55 = r1;
        ContentResolverMediaSource r111 = r22;
        if ((!r55.isEmpty()) == false) goto L227;
        int r0 = e0.a;     // Catch: Throwable -> L233
        e0.c(r111.c, "createMediaItemFromCursor errorStats=" + r55);     // Catch: Throwable -> L233
    L227:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L233
        CloseableKt.closeFinally(r7, null);     // Catch: Exception -> L231
        return;
    L233:
        th = th;
    L218:
        Cursor r24 = r7;
    L244:
        Throwable r25 = th;
    L254:
        throw r25;     // Catch: Throwable -> L246
    L246:
        th = move-exception;
        CloseableKt.closeFinally(r24, r25);     // Catch: Exception -> L231
        throw th;     // Catch: Exception -> L231
    L298:
    L235:
        th = th;
        r24 = r7;
        r111 = r22;
        goto L244
    L31:
        if (r8.moveToNext() == false) goto L29;
        if (r8.isNull(r9) == false) goto L35;
        Long r26 = null;
    L37:
        int r27 = r9;
        int r52 = r3;
        long r28 = ((Number) e(r26, r1, "id", 0L)).longValue();     // Catch: Exception -> L211 Throwable -> L216
        if (r8.isNull(r10) == false) goto L43;
        String r29 = null;
    L293:
        String r30 = (String) e(r29, r1, "name", r6);     // Catch: Exception -> L208 Throwable -> L216
        if (r8.isNull(r12) == false) goto L48;
        String r112 = null;
    L311:
        String r113 = (String) e(r112, r1, "mimeType", r6);     // Catch: Exception -> L205 Throwable -> L216
        if (r8.isNull(r13) == false) goto L53;
        Integer r114 = null;
    L54:
        int r46 = r13;
        int r115 = ((Number) e(r114, r1, r5, 0)).intValue();     // Catch: Exception -> L203 Throwable -> L216
        if (r8.isNull(r14) == false) goto L58;
        Integer r116 = null;
    L59:
        r5 = r5;
        int r31 = ((Number) e(r116, r1, r4, 0)).intValue();     // Catch: Exception -> L201 Throwable -> L216
        if (r8.isNull(r15) == false) goto L63;
        Long r117 = null;
    L66:
        int r49 = r14;
        long r118 = ((Number) e(r117, r1, "size", 0L)).longValue();     // Catch: Exception -> L195 Throwable -> L216
        if (r8.isNull(r17) == false) goto L70;
        Long r32 = null;
    L73:
        int r51 = r15;
        long r33 = ((Number) e(r32, r1, "folderId", -1L)).longValue();     // Catch: Exception -> L189 Throwable -> L216
        if (r8.isNull(r52) == false) goto L77;
        String r119 = null;
    L309:
        String r34 = (String) e(r119, r1, "folderName", r6);     // Catch: Exception -> L187 Throwable -> L216
        r21 = r21;
    L185:
        e = e;
        r1 = r1;
        r6 = r6;
        r110 = r110;
        r21 = r21;
    L181:
        r18 = r18;
        r111 = r22;
        r8 = r8;
    L221:
        int r35 = e0.a;     // Catch: Throwable -> L233
        e0.c(r111.c, "createMediaItemFromCursor parse item failed: " + e.getMessage());     // Catch: Throwable -> L233
    L222:
        r110 = r110;
    L223:
        r2 = r61;
        r18 = r18;
        r8 = r8;
        r9 = r27;
        r10 = r10;
        r12 = r12;
        r13 = r46;
        r5 = r5;
        r4 = r4;
        r14 = r49;
        r17 = r17;
        r3 = r52;
        r6 = r6;
        r1 = r1;
        r22 = r111;
        r15 = r51;
        goto L26
    L82:
        if (r8.isNull(r21) == false) goto L84;
        Long r36 = null;
    L87:
        r110 = r110;
        long r37 = ((Number) e(r36, r1, "dateAdded", 0L)).longValue();     // Catch: Exception -> L179 Throwable -> L216
        r19 = r19;
        if (r8.isNull(r19) == false) goto L93;
        Long r120 = null;
    L94:
        if (r120 == null) goto L97;
        long r56 = r120.longValue();     // Catch: Exception -> L175 Throwable -> L235
    L99:
        if (r118 <= 0) goto L270;
        r19 = r19;
        r111 = r22;
        long r38 = r33;
        ContentResolverMediaSource r39 = r57;
        r8 = r8;
        long r40 = r56;
    L133:
        if (r115 <= 0) goto L282;
        if (r31 <= 0) goto L282;
        r1 = r1;
        String r121 = r34;
        long r41 = r28;
        long r42 = r37;
    L145:
        r18 = r18;
        ContentResolverMediaSource r122 = r111;
        if (StringsKt.startsWith$default(r113, r18, false, 2, null) == false) goto L149;
        Uri r43 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r41);     // Catch: Exception -> L160 Throwable -> L162
    L150:
        Uri r210 = r43;
        Intrinsics.checkNotNull(r210);     // Catch: Exception -> L160 Throwable -> L162
        if (StringsKt.startsWith$default(r113, r18, false, 2, null) == false) goto L155;
        MediaType r123 = MediaType.IMAGE;     // Catch: Exception -> L158 Throwable -> L162
    L156:
        ((ArrayList) r59).add(new mp9.c(r41, r210, r123, r30, r38, r121, r113, r42, r40, r115, r31, r118));     // Catch: Exception -> L158 Throwable -> L162
        r110 = r110 + 1;
        r111 = r122;
        goto L223
    L155:
        r123 = MediaType.VIDEO;     // Catch: Exception -> L158 Throwable -> L162
    L158:
        e = e;
    L178:
        r111 = r122;
        goto L221
    L149:
        r43 = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r41);     // Catch: Exception -> L160 Throwable -> L162
        goto L150
    L160:
        e = e;
    L162:
        th = th;
    L163:
        r24 = r7;
        r111 = r122;
    L282:
        int r211 = e0.a;     // Catch: Throwable -> L170 Exception -> L172
        r1 = r1;
        String r44 = r111.c;     // Catch: Exception -> L168 Throwable -> L170
        StringBuilder r124 = new StringBuilder();     // Catch: Exception -> L168 Throwable -> L170
        r124.append("createMediaItemFromCursor Invalid dimensions: ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r28);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r30);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r113);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r42 = r37;
        r124.append(r42);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r115);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r31);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r38);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r121 = r34;
        r124.append(r121);     // Catch: Exception -> L164 Throwable -> L166
        r124.append(", ");     // Catch: Exception -> L164 Throwable -> L166
        r124.append(r40);     // Catch: Exception -> L164 Throwable -> L166
        e0.c(r44, r124.toString());     // Catch: Exception -> L164 Throwable -> L166
        if (((s) r39.d.getValue()).a() == false) goto L144;
        e0.c(r111.c, "createMediaItemFromCursor Filter by dimensions: id=" + r28 + ", width=" + r115 + ", height=" + r31);     // Catch: Exception -> L168 Throwable -> L233
    L143:
        r18 = r18;
        goto L222
    L144:
        r41 = r28;
        goto L145
    L164:
        e = e;
    L177:
        r122 = r111;
    L166:
        th = th;
        r122 = r111;
    L168:
        e = e;
    L174:
        r111 = r111;
    L172:
        e = e;
        r1 = r1;
    L170:
        th = th;
        goto L218
    L270:
        int r125 = e0.a;     // Catch: Exception -> L129 Throwable -> L216
        r111 = r22;
        String r126 = r111.c;     // Catch: Exception -> L127 Throwable -> L233
        r19 = r19;
        StringBuilder r45 = new StringBuilder();     // Catch: Throwable -> L121 Exception -> L124
        r8 = r8;
        r45.append("createMediaItemFromCursor Invalid size: ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r28);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r30);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r113);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r37);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r115);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r31);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r118);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r38 = r33;
        r45.append(r38);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r45.append(r34);     // Catch: Exception -> L119 Throwable -> L121
        r45.append(", ");     // Catch: Exception -> L119 Throwable -> L121
        r40 = r56;
        r45.append(r40);     // Catch: Exception -> L119 Throwable -> L121
        e0.c(r126, r45.toString());     // Catch: Exception -> L119 Throwable -> L121
        r39 = r57;
        if (((s) r39.d.getValue()).b() == true) goto L272;
        r111 = r39;
        goto L133
    L272:
        e0.c(r39.c, "createMediaItemFromCursor Filter by size: id=" + r28 + ", size=" + r118);     // Catch: Throwable -> L112 Exception -> L114
        r1 = r1;
        r111 = r39;
        goto L143
    L112:
        th = th;
        r24 = r7;
        r111 = r39;
    L117:
        th = th;
    L123:
        r24 = r7;
        r25 = th;
        r111 = r39;
    L114:
        e = e;
    L126:
        r1 = r1;
        r111 = r39;
        goto L177
    L119:
        e = e;
        r39 = r57;
    L121:
        th = th;
        r39 = r57;
    L124:
        e = e;
        r39 = r57;
        r8 = r8;
    L127:
        e = e;
    L131:
        r1 = r1;
    L129:
        e = e;
        r111 = r22;
        goto L131
    L97:
        r56 = 0;
        goto L99
    L93:
        r120 = Long.valueOf(r8.getLong(r19));     // Catch: Exception -> L175 Throwable -> L216
    L175:
        e = e;
        r1 = r1;
        r19 = r19;
        r111 = r22;
        r8 = r8;
    L179:
        e = e;
        r1 = r1;
        goto L181
    L84:
        r36 = Long.valueOf(r8.getLong(r21));     // Catch: Exception -> L185 Throwable -> L216
    L187:
        e = e;
    L184:
        r110 = r110;
        goto L181
    L77:
        r119 = r8.getString(r52);     // Catch: Exception -> L189 Throwable -> L216
    L189:
        e = e;
        r52 = r52;
        goto L184
    L70:
        r32 = Long.valueOf(r8.getLong(r17));     // Catch: Exception -> L195 Throwable -> L216
    L195:
        e = e;
        r1 = r1;
        r6 = r6;
        r17 = r17;
        r52 = r52;
        r110 = r110;
    L194:
        r51 = r15;
        goto L181
    L63:
        r117 = Long.valueOf(r8.getLong(r15));     // Catch: Exception -> L201 Throwable -> L216
    L201:
        e = e;
    L199:
        r6 = r6;
        r17 = r17;
        r52 = r52;
        r110 = r110;
    L200:
        r49 = r14;
        goto L194
    L58:
        r116 = Integer.valueOf(r8.getInt(r14));     // Catch: Exception -> L203 Throwable -> L216
    L203:
        e = e;
        r5 = r5;
        goto L199
    L53:
        r114 = Integer.valueOf(r8.getInt(r13));     // Catch: Exception -> L205 Throwable -> L216
    L205:
        e = e;
        r1 = r1;
        r4 = r4;
        r5 = r5;
        r6 = r6;
        r17 = r17;
        r52 = r52;
    L207:
        r46 = r13;
        goto L200
    L48:
        r112 = r8.getString(r12);     // Catch: Exception -> L208 Throwable -> L216
    L208:
        e = e;
        r1 = r1;
        r4 = r4;
        r5 = r5;
        r6 = r6;
        r17 = r17;
        r52 = r52;
    L210:
        r12 = r12;
        goto L207
    L43:
        r29 = r8.getString(r10);     // Catch: Exception -> L211 Throwable -> L216
    L211:
        e = e;
        r52 = r52;
    L215:
        r10 = r10;
    L213:
        e = e;
        r52 = r3;
        goto L215
    L35:
        r26 = Long.valueOf(r8.getLong(r9));     // Catch: Throwable -> L216 Exception -> L219
    L219:
        e = e;
        r52 = r3;
        r27 = r9;
    L216:
        th = th;
        r111 = r22;
        goto L218
    L268:
        r8.move((r60 - 1) * r2);     // Catch: Throwable -> L22
    L22:
        th = th;
        r111 = r57;
        goto L218
    L17:
        r20 = false;
    L237:
        th = th;
        r24 = r7;
    L243:
        r111 = r57;
    L241:
        th = th;
        r24 = r7;
    L250:
        e = e;
        r111 = r57;
    L252:
        int r47 = e0.a;
        e0.c(r111.c, "createMediaItemFromCursor failed: " + e.getMessage());
        return;
    L231:
        e = e;
        goto L252
    }
}
