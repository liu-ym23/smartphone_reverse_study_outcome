package kotlin.text;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "Lkotlin/text/FlagEnum;", "", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Enum;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class RegexKt$fromInt$1$1<T> extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ int $value;

    public RegexKt$fromInt$1$1(int r1) {
        this.$value = r1;
        super(1);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
    public final Boolean invoke(Enum r3) {
        FlagEnum r4 = (FlagEnum) r3;
        if ((this.$value & r4.getMask()) != r4.getValue()) goto L5;
        boolean r5 = true;
    L7:
        return Boolean.valueOf(r5);
    L5:
        r5 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Enum) r1);
    }
}
