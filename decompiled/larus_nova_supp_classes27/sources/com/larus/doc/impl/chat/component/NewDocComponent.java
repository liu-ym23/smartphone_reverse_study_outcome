package com.larus.doc.impl.chat.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/impl/chat/component/NewDocComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/chat/ability/INewDocAbility;", "<init>", "()V", "createNewDoc", "", "isFromClickVoice", "", "createNewDocV2", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewDocComponent extends Component implements g39.c {

    public static final class a {
    }

    static {
    }

    @Override // g39.c
    public final void HA() {
        FLogger.a.i("NewDocComponent", "createNewDoc, isFromClickVoice:false");
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new NewDocComponent$createNewDocV2$1(this, false, null), 3, null);
    }

    public NewDocComponent() {
    }
}
