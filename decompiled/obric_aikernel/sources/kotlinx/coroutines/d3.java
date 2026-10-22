package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public final class d3 extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10337g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public boolean f10338c;

    public static final class a implements CoroutineContext.Key<d3> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f10337g = new a(null);
    }

    public d3() {
        super(f10337g);
    }
}
