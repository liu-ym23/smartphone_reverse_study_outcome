package androidx.room.vo;

import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.migration.bundle.BundleUtil;
import androidx.room.migration.bundle.DatabaseViewBundle;
import androidx.room.parser.ParsedQuery;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0006\u0010#\u001a\u00020$R\u001b\u0010\u0014\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/room/vo/DatabaseView;", "Landroidx/room/vo/Pojo;", "Landroidx/room/vo/HasSchemaIdentity;", "Landroidx/room/vo/EntityOrView;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "viewName", "", "query", "Landroidx/room/parser/ParsedQuery;", "type", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "constructor", "Landroidx/room/vo/Constructor;", "(Landroidx/room/compiler/processing/XTypeElement;Ljava/lang/String;Landroidx/room/parser/ParsedQuery;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/Constructor;)V", "createViewQuery", "getCreateViewQuery", "()Ljava/lang/String;", "createViewQuery$delegate", "Lkotlin/Lazy;", "getQuery", "()Landroidx/room/parser/ParsedQuery;", "tableName", "getTableName", "tables", "", "getTables", "()Ljava/util/Set;", "getViewName", "getIdKey", "toBundle", "Landroidx/room/migration/bundle/DatabaseViewBundle;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseView extends Pojo implements HasSchemaIdentity, EntityOrView {
    private final Lazy createViewQuery$delegate;
    private final ParsedQuery query;
    private final String tableName;
    private final Set<String> tables;
    private final String viewName;

    public DatabaseView(XTypeElement r10, String r11, ParsedQuery r12, XType r13, List<Field> r14, List<EmbeddedField> r15, Constructor r16) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "viewName");
        Intrinsics.checkNotNullParameter(r12, "query");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "fields");
        Intrinsics.checkNotNullParameter(r15, "embeddedFields");
        super(r10, r13, r14, r15, CollectionsKt.emptyList(), r16);
        this.viewName = r11;
        this.query = r12;
        this.tableName = r11;
        this.createViewQuery$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.tables = new LinkedHashSet();
    }

    public static final /* synthetic */ String access$createViewQuery(DatabaseView r5, String r10) {
        return r5.createViewQuery(r10);
    }

    private final String createViewQuery(String r5) {
        return androidx.constraintlayout.motion.widget.a.p("CREATE VIEW `", r5, "` AS ", StringsKt.trim(this.query.getOriginal()).toString());
    }

    public final String getCreateViewQuery() {
        return (String) this.createViewQuery$delegate.getValue();
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        SchemaIdentityKey r5 = new SchemaIdentityKey();
        r5.append(this.query.getOriginal());
        return r5.hash();
    }

    public final ParsedQuery getQuery() {
        return this.query;
    }

    @Override // androidx.room.vo.EntityOrView
    public String getTableName() {
        return this.tableName;
    }

    public final Set<String> getTables() {
        return this.tables;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final DatabaseViewBundle toBundle() {
        return new DatabaseViewBundle(this.viewName, createViewQuery(BundleUtil.VIEW_NAME_PLACEHOLDER));
    }
}
