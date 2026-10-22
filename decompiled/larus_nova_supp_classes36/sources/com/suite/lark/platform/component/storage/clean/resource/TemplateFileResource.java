package com.suite.lark.platform.component.storage.clean.resource;

import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/TemplateFileResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/FileCleanResource;", "path", "", "<init>", "(Ljava/lang/String;)V", "Companion", "ParamValueProvider", "SimpleParamProvider", "Builder", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TemplateFileResource extends FileCleanResource {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* synthetic */ TemplateFileResource(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private TemplateFileResource(String r2) {
        super(r2, Biz.DEFAULT);
    }
}
