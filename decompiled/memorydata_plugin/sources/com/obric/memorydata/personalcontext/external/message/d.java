package com.obric.memorydata.personalcontext.external.message;

import android.database.Cursor;
import android.net.Uri;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 ¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/GRRmsProvider;", "Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;", "<init>", "()V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "filePathColumn", "", "idColumn", "getIdColumn", "()Ljava/lang/String;", "dateColumn", "getDateColumn", "dateSentColumn", "getDateSentColumn", "threadIdColumn", "getThreadIdColumn", "addressColumn", "getAddressColumn", "bodyColumn", "getBodyColumn", "typeColumn", "getTypeColumn", "projection", "", "getProjection", "()[Ljava/lang/String;", "[Ljava/lang/String;", "filePathColumnIndex", "", "Ljava/lang/Integer;", "getAttachments", "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "cursor", "Landroid/database/Cursor;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f12157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12158b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String[] j;
    private Integer k;

    public d() {
        this.f12157a = Uri.parse("content://rms/rms_log");
        this.f12158b = "file_path";
        this.c = "_id";
        this.d = "date";
        this.e = "date_sent";
        this.f = "thread_id";
        this.g = "rms_address";
        this.h = "rms_body";
        this.i = "rms_type";
        this.j = new String[]{b(), c(), d(), f(), g(), e(), h(), "file_path"};
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public Uri a() {
        return this.f12157a;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public List<FileEntity> a(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        if (this.k != null) goto L8;
        this.k = Integer.valueOf(r6.getColumnIndex(this.f12158b));
    L8:
        Integer r2 = this.k;
        int r3 = -1;
        if (r2 != null) goto L12;
    L13:
        Integer r4 = this.k;
        if (r4 == null) goto L16;
        r3 = r4.intValue();
    L16:
        String r7 = r6.getString(r3);
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        File r10 = new File(r7);
        return CollectionsKt.listOf(FileEntity.CREATOR.create(r10, Uri.parse(r7)));
    L26:
        return null;
    L19:
        if (r8.length() == 0) goto L22;
        r9 = false;
        goto L23
    L12:
        if (r2.intValue() == (-1)) goto L26;
        goto L13
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String b() {
        return this.c;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String c() {
        return this.d;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String d() {
        return this.e;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String e() {
        return this.f;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String f() {
        return this.g;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String g() {
        return this.h;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String h() {
        return this.i;
    }

    @Override // com.obric.memorydata.personalcontext.external.message.e
    public String[] i() {
        return this.j;
    }
}
