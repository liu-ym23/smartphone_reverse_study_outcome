package w79;

import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c {
    void a(DriveFileItem r1);

    void b(DriveFileItem r1);

    boolean c(DriveFileItem r1);

    void d(List<DriveFileItem> r1);

    a e(DriveFileItem r1);

    void onCanceled();

    void onChanged(List<DriveFileItem> r1);

    void onSelectMoreClick();
}
