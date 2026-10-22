package com.obric.memorydata.personalcontext.external.message;

import android.database.Cursor;
import android.net.Uri;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;", "", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "idColumn", "", "getIdColumn", "()Ljava/lang/String;", "dateColumn", "getDateColumn", "dateSentColumn", "getDateSentColumn", "addressColumn", "getAddressColumn", "bodyColumn", "getBodyColumn", "threadIdColumn", "getThreadIdColumn", "typeColumn", "getTypeColumn", "projection", "", "getProjection", "()[Ljava/lang/String;", "getAttachments", "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "cursor", "Landroid/database/Cursor;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface e {
    Uri a();

    List<FileEntity> a(Cursor r1);

    String b();

    String c();

    String d();

    String e();

    String f();

    String g();

    String h();

    String[] i();
}
