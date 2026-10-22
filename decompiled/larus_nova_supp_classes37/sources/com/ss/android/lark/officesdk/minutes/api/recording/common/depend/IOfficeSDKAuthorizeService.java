package com.ss.android.lark.officesdk.minutes.api.recording.common.depend;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IOfficeSDKAuthorizeService extends IOfficeSDKProtocol {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/IOfficeSDKAuthorizeService$Scope;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "USER_LOCATION", "USER_FUZZY_LOCATION", "USER_LOCATION_BACKGROUND", "RECORD", "BLUETOOTH", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum Scope extends Enum<Scope> {
        public static final Scope BLUETOOTH = null;
        public static final a Companion = null;
        public static final Scope RECORD = null;
        public static final Scope USER_FUZZY_LOCATION = null;
        public static final Scope USER_LOCATION = null;
        public static final Scope USER_LOCATION_BACKGROUND = null;
        public static final Set<String> a = null;
        public static final /* synthetic */ Scope[] b = null;
        public static final /* synthetic */ EnumEntries c = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Scope> getEntries() {
            return c;
        }

        static {
            Scope r0 = new Scope("USER_LOCATION", 0, "scope.userLocation");
            USER_LOCATION = r0;
            Scope r1 = new Scope("USER_FUZZY_LOCATION", 1, "scope.userFuzzyLocation");
            USER_FUZZY_LOCATION = r1;
            Scope r3 = new Scope("USER_LOCATION_BACKGROUND", 2, "scope.userLocationBackground");
            USER_LOCATION_BACKGROUND = r3;
            Scope r5 = new Scope("RECORD", 3, "scope.record");
            RECORD = r5;
            Scope r7 = new Scope("BLUETOOTH", 4, "scope.bluetooth");
            BLUETOOTH = r7;
            Scope[] r9 = {r0, r1, r3, r5, r7};
            b = r9;
            c = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
            EnumEntries<Scope> r2 = getEntries();
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r6 = r2.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            r4.add(((Scope) r6.next()).value);
            goto L4
        L6:
            a = CollectionsKt.toSet(r4);
        }

        public static Scope[] values() {
            return (Scope[]) b.clone();
        }

        public static final /* synthetic */ Set access$getVALUES$cp() {
            return a;
        }

        public final String getValue() {
            return this.value;
        }

        public static Scope valueOf(String r1) {
            return (Scope) r27.a.a(Scope.class, r1);
        }

        public Scope(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final boolean a;
        public final String b;

        public /* synthetic */ a() {
            this(true, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "AuthorizeResult(success=" + this.a + ", reason=" + this.b + ')';
        }

        public a(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    boolean Q0();

    Object S1(Scope r1, Continuation<? super Boolean> r2);

    Object c1(Scope r1, Continuation<? super a> r2);

    Object e0(FragmentActivity r1, Continuation r2);
}
