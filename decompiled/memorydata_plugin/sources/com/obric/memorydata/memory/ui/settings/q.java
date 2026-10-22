package com.obric.memorydata.memory.ui.settings;

import com.obric.memorydata.memory.utils.PinShortcutRequestSupport;
import com.obric.memorydata.memory.utils.PinShortcutStartResult;
import com.obric.memorydata.memory.utils.PinShortcutSupersedeProvenance;
import com.obric.memorydata.memory.utils.PinnedShortcutState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J0\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH&J*\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\u0004\u0012\u00020\f0\nH&J\b\u0010\u0013\u001a\u00020\fH&¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutGateway;", "", "queryPinnedState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "enableExistingAndQuery", "queryPinRequestSupport", "Lcom/obric/memorydata/memory/utils/PinShortcutRequestSupport;", "requestNewPin", "Lcom/obric/memorydata/memory/utils/PinShortcutStartResult;", "onGenerationStarted", "Lkotlin/Function1;", "", "", "onGenerationAbandoned", "supersedePinRequests", "provenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "onGenerationsSuperseded", "", "disable", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface q {
    PinShortcutStartResult a(Function1<? super Long, Unit> r1, Function1<? super Long, Unit> r2);

    PinnedShortcutState a();

    void a(PinShortcutSupersedeProvenance r1, Function1<? super Set<Long>, Unit> r2);

    PinnedShortcutState b();

    PinShortcutRequestSupport c();

    void d();
}
