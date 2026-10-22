package androidx.room.vo;

import com.lynx.tasm.behavior.v0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u000e\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\n0\nR\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/vo/SchemaIdentityKey;", "", "()V", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "append", "", "identity", "Landroidx/room/vo/HasSchemaIdentity;", "", "appendSorted", "identities", "", "hash", "kotlin.jvm.PlatformType", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SchemaIdentityKey {
    public static final Companion Companion = null;
    private static final Comparator<String> ENGLISH_SORT = null;
    private static final String SEPARATOR = null;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    private final StringBuilder f693sb;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/vo/SchemaIdentityKey$Companion;", "", "()V", "ENGLISH_SORT", "Ljava/util/Comparator;", "", "SEPARATOR", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        SEPARATOR = "?:?";
        ENGLISH_SORT = new a(0);
    }

    public SchemaIdentityKey() {
        this.f693sb = new StringBuilder();
    }

    private static final int ENGLISH_SORT$lambda$2(String r5, String r10) {
        Locale r11 = Locale.ENGLISH;
        return r5.toLowerCase(r11).compareTo(r10.toLowerCase(r11));
    }

    public static /* synthetic */ int a(String r5, String r10) {
        return ENGLISH_SORT$lambda$2(r5, r10);
    }

    public final void append(HasSchemaIdentity r5) {
        Intrinsics.checkNotNullParameter(r5, "identity");
        append(r5.getIdKey());
    }

    public final void appendSorted(List<? extends HasSchemaIdentity> r5) {
        Intrinsics.checkNotNullParameter(r5, "identities");
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((HasSchemaIdentity) r11.next()).getIdKey());
        goto L4
    L6:
        Iterator r12 = CollectionsKt.sortedWith(r10, ENGLISH_SORT).iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        append((String) r12.next());
        goto L8
    }

    public final String hash() {
        return v0.w(this.f693sb.toString());
    }

    public final void append(String r5) {
        Intrinsics.checkNotNullParameter(r5, "identity");
        StringBuilder r10 = this.f693sb;
        r10.append(r5);
        r10.append(SEPARATOR);
    }
}
