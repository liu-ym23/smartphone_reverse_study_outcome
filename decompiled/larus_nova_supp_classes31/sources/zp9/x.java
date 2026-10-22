package zp9;

import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final PublisherCreation a(UserCreationFromIM r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        return new PublisherCreation(r19.getCreationId(), r19.getCreationType(), null, null, r19.getPrompt(), null, r19.getRefContent(), null, null, false, r19.getMaterialId(), null, null, null, 15276, null);
    }
}
