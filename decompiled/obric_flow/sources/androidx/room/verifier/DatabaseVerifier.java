package androidx.room.verifier;

import ai.j0;
import androidx.room.compiler.processing.XElement;
import androidx.room.processor.Context;
import androidx.room.vo.DatabaseView;
import androidx.room.vo.Entity;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.FtsEntity;
import androidx.room.vo.FtsOptions;
import androidx.room.vo.Index;
import androidx.room.vo.Warning;
import av.d;
import av.i;
import com.bytedance.common.wschannel.WsConstants;
import dv.a;
import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\n \u001b*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/room/verifier/DatabaseVerifier;", "", WsConstants.KEY_CONNECTION, "Ljava/sql/Connection;", "context", "Landroidx/room/processor/Context;", "entities", "", "Landroidx/room/vo/Entity;", "views", "Landroidx/room/vo/DatabaseView;", "(Ljava/sql/Connection;Landroidx/room/processor/Context;Ljava/util/List;Ljava/util/List;)V", "getConnection", "()Ljava/sql/Connection;", "getContext", "()Landroidx/room/processor/Context;", "entitiesAndViews", "Landroidx/room/vo/EntityOrView;", "getEntitiesAndViews", "()Ljava/util/List;", "analyze", "Landroidx/room/verifier/QueryResultInfo;", "sql", "", "closeConnection", "", "stripLocalizeCollations", "kotlin.jvm.PlatformType", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseVerifier {
    private static final Pattern COLLATE_LOCALIZED_UNICODE_PATTERN = null;
    private static final String CONNECTION_URL = "jdbc:sqlite::memory:";
    public static final Companion Companion = null;
    private static final Driver DRIVER = null;
    private final Connection connection;
    private final Context context;
    private final List<EntityOrView> entitiesAndViews;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ4\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/verifier/DatabaseVerifier$Companion;", "", "()V", "COLLATE_LOCALIZED_UNICODE_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CONNECTION_URL", "", "DRIVER", "Ljava/sql/Driver;", "cleanup", "", "create", "Landroidx/room/verifier/DatabaseVerifier;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XElement;", "entities", "", "Landroidx/room/vo/Entity;", "views", "Landroidx/room/vo/DatabaseView;", "verifyTempDir", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ void access$verifyTempDir(Companion r5) {
            r5.verifyTempDir();
        }

        private final void verifyTempDir() {
            String r5 = System.getProperty("org.sqlite.tmpdir", System.getProperty("java.io.tmpdir"));
            if (r5 == null) goto L18;
            File r10 = new File(r5);
            if (r10.isDirectory() == false) goto L16;
            if (r10.exists() == true) goto L11;
            if (r10.mkdirs() == false) goto L16;
        L11:
            if (r10.canRead() == false) goto L16;
            if (r10.canWrite() == false) goto L16;
            return;
        L16:
            throw new IllegalStateException(j0.k("The temp dir [", r5, "] needs to be a directory, must be readable, writable and allow executables. Please, provide a temporary directory that fits the requirements via the 'org.sqlite.tmpdir' property.").toString());
        L18:
            throw new IllegalStateException("Room needs the java.io.tmpdir or org.sqlite.tmpdir system property to be set to setup SQLite.");
        }

        public final void cleanup() {
            DriverManager.deregisterDriver(DatabaseVerifier.access$getDRIVER$cp());     // Catch: SQLException -> L4
            return;
        }

        public final DatabaseVerifier create(Context r11, XElement r12, List<? extends Entity> r13, List<DatabaseView> r14) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "element");
            Intrinsics.checkNotNullParameter(r13, "entities");
            Intrinsics.checkNotNullParameter(r14, "views");
            DriverManager.registerDriver(DatabaseVerifier.access$getDRIVER$cp());     // Catch: Exception -> L9
            Properties r5 = new Properties();     // Catch: Exception -> L9
            if (d.a(DatabaseVerifier.CONNECTION_URL) == true) goto L6;
            a r10 = null;
        L7:
            return new DatabaseVerifier(r10, r11, r13, r14, null);
        L6:
            r10 = new a(DatabaseVerifier.CONNECTION_URL, ":memory:", r5);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            r11.getLogger().w(Warning.CANNOT_CREATE_VERIFICATION_DATABASE, r12, DatabaseVerificationErrors.INSTANCE.cannotCreateConnection(e), new Object[0]);
            return null;
        }

        private Companion() {
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        COLLATE_LOCALIZED_UNICODE_PATTERN = Pattern.compile("\\s+COLLATE\\s+(LOCALIZED|UNICODE)", 2);
        Companion.access$verifyTempDir(r5);
        monitor-enter(System.class);
        i.r();     // Catch: Throwable -> L9
        d.a(CONNECTION_URL);     // Catch: Throwable -> L9
        Driver r10 = DriverManager.getDriver("jdbc:sqlite:");     // Catch: Throwable -> L9
        DRIVER = r10;     // Catch: Throwable -> L9
        if ((r10 instanceof d) == false) goto L12;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(System.class);
        return;
    L12:
        throw new IllegalStateException(("Expected driver to be a '" + d.class + "' but was '" + r10.getClass() + "'").toString());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ DatabaseVerifier(Connection r5, Context r10, List r11, List r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public static final /* synthetic */ Driver access$getDRIVER$cp() {
        return DRIVER;
    }

    private final String stripLocalizeCollations(String r5) {
        return COLLATE_LOCALIZED_UNICODE_PATTERN.matcher(r5).replaceAll(" COLLATE NOCASE");
    }

    public final QueryResultInfo analyze(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        return new QueryResultInfo(Jdbc_extKt.columnInfo(this.connection.prepareStatement(stripLocalizeCollations(r5))), null, 2, null);
    L5:
        e = move-exception;
        return new QueryResultInfo(CollectionsKt.emptyList(), e);
    }

    public final void closeConnection(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.connection.isClosed() == true) goto L11;
        this.connection.close();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        r5.getLogger().d(j0.C("failed to close the database connection ", th.getMessage()), new Object[0]);
        return;
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<EntityOrView> getEntitiesAndViews() {
        return this.entitiesAndViews;
    }

    private DatabaseVerifier(Connection r5, Context r10, List<? extends Entity> r11, List<DatabaseView> r12) {
        this.connection = r5;
        this.context = r10;
        this.entitiesAndViews = CollectionsKt.plus(r11, r12);
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        Entity r14 = (Entity) r13.next();
        Statement r15 = this.connection.createStatement();
        if ((r14 instanceof FtsEntity) == false) goto L10;
        FtsEntity r16 = (FtsEntity) r14;
        if (FtsOptions.Companion.getDefaultTokenizers().contains(r16.getFtsOptions().getTokenizer()) == true) goto L10;
        String r17 = r16.getCreateTableQueryWithoutTokenizer();
    L28:
        r15.executeUpdate(stripLocalizeCollations(r17));     // Catch: SQLException -> L13
    L15:
        Iterator<T> r18 = r14.getIndices().iterator();
    L17:
        if (r18.hasNext() == false) goto L4;
        r15.executeUpdate(((Index) r18.next()).createQuery(r14.getTableName()));
    L13:
        e = move-exception;
        this.context.getLogger().e(r14.getElement(), String.valueOf(e.getMessage()), new Object[0]);
    L10:
        r17 = r14.getCreateTableQuery();
        goto L28
    L19:
        Iterator<T> r19 = r12.iterator();
    L21:
        if (r19.hasNext() == false) goto L27;
        DatabaseView r20 = (DatabaseView) r19.next();
        Statement r21 = this.connection.createStatement();
        r21.executeUpdate(stripLocalizeCollations(r20.getCreateViewQuery()));     // Catch: SQLException -> L25
    L25:
        e = move-exception;
        this.context.getLogger().e(r20.getElement(), String.valueOf(e.getMessage()), new Object[0]);
        goto L21
    }
}
