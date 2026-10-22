package com.suite.lark.platform.component.storage.clean.request;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.f;
import com.suite.lark.platform.component.storage.clean.m;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/request/ResetAllRequest;", "Lcom/suite/lark/platform/component/storage/clean/CleanRequest;", "Lcom/suite/lark/platform/component/storage/clean/request/ResetAllRequest$ResetAllResource;", "<init>", "()V", "Companion", "ResetAllResource", "ResetAllEraser", "Builder", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ResetAllRequest extends CleanRequest<c> {
    public static final a Companion = null;
    private static final String Name = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements m<c> {
        public b() {
        }

        @Override // com.suite.lark.platform.component.storage.clean.m
        public final Class<c> a() {
            return c.class;
        }
    }

    public static final class c implements f {
        public c() {
        }

        @Override // com.suite.lark.platform.component.storage.clean.f
        public final long progressWeight() {
            return 1;
        }
    }

    static {
        Companion = new a();
        Name = "clean_reset_all_data";
    }

    public ResetAllRequest() {
        super(Name, 1, CollectionsKt.listOf(new c()), null, 8, null);
    }

    public static final String getName() {
        Companion.getClass();
        return access$getName$cp();
    }

    public static final /* synthetic */ String access$getName$cp() {
        return Name;
    }
}
