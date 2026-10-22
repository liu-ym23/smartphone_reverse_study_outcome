package com.obric.assistant.common.spi.audio;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oda.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/common/spi/audio/ObricAudioServiceDelegate;", "Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "<init>", "()V", "service", "getService", "()Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "service$delegate", "Lkotlin/Lazy;", "shouldNotPlayTts", NameKeys.UnloadStrategy_No_Strategy, "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "isOAutoCallUserMessageMustPlayTts", "getCurrentAudioFocusOwner", NameKeys.UnloadStrategy_No_Strategy, "isSystemNotification", "isCurrentFocusOwnerPhoneCall", "shouldBypassFocusFail", "scene", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioServiceDelegate implements IObricAudioService {
    public static final ObricAudioServiceDelegate a = null;
    public static final Lazy b = null;

    private ObricAudioServiceDelegate() {
    }

    static {
        a = new ObricAudioServiceDelegate();
        b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final String c() {
        IObricAudioService r0 = (IObricAudioService) b.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.c();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean d() {
        IObricAudioService r0 = (IObricAudioService) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean e() {
        IObricAudioService r0 = (IObricAudioService) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        IObricAudioService r0 = (IObricAudioService) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b(r2);
    }
}
